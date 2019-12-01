
package main.com.company.java;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Message;
import main.com.company.java.vkconfig.VKCore;
import main.com.company.java.vkconfig.VKManager;

import java.util.Random;

public class Character
{
    public String name;
    public int level;
    public int maximumHealth;
    public int currentHealth;
    int maximalDamage;
    int minimalDamage;
    int criticalChance;
    int damageReduction;
    int evasionChance;
    int experience;
    public Character currentTarget;
    static int[] experienceForLevelUp = {1000, 2000, 3000, 5000};

    public Character(String name, int level, int health, int maximalDamage, int minimalDamage, int criticalChance, int damageReduction, int evasionChance, int experience)
    {
        this.name = name;
        this.level = level;
        this.maximumHealth = health;
        this.currentHealth = this.maximumHealth;
        this.maximalDamage = maximalDamage;
        this.minimalDamage = minimalDamage;
        this.criticalChance = criticalChance;
        this.damageReduction = damageReduction;
        this.evasionChance = evasionChance;
        this.experience = experience;
    }

    public boolean isDead()
    {
        return !isAlive();
    }

    private void getExperience(Character target, Message msg)
    {
        this.experience += target.experience;
        if (this.experience >= experienceForLevelUp[this.level - 1])
            this.levelUp(msg);
    }

    public void levelUp(Message msg)
    {
        this.level++;
        this.maximumHealth += (int)(this.maximumHealth / 10);
        this.currentHealth = this.maximumHealth;
        this.maximalDamage += (int)(this.maximalDamage / 10);
        this.minimalDamage += (int)(this.minimalDamage / 10);
        this.criticalChance += (int)(this.criticalChance / 10);
        this.damageReduction += (int)(this.damageReduction / 10);
        this.evasionChance += (int)(this.evasionChance / 10);
        new VKManager().sendMessage("********" + this.name + " достигает " + this.level + " уровня!" + "********", msg.getUserId());
    }

    public boolean isAlive()
    {
        return this.currentHealth > 0;
    }

    public void restoreHealth()
    {
        this.currentHealth = this.maximumHealth;
    }

    public void attack(Character target, Message msg) throws InterruptedException {
        new VKManager().sendMessage(this.name + " атакует!", msg.getUserId());
        var random = new Random();
        var currentDamage = random.nextInt(this.maximalDamage - this.minimalDamage + 1) + minimalDamage;
        var currentCritChance = random.nextInt(100) + 1;
        if (currentCritChance <= this.criticalChance)
        {
            currentDamage *= 2;
            new VKManager().sendMessage("Критический удар!", msg.getUserId());
        }
        var currentEvasionChance = random.nextInt(100) + 1;
        if (currentEvasionChance <= target.evasionChance)
        {
            new VKManager().sendMessage(target.name + " уклоняется!", msg.getUserId() );
            return;
        }
        else
        {
            currentDamage = currentDamage * (100 - target.damageReduction) / 100;
            target.currentHealth -= currentDamage;
            new VKManager().sendMessage(target.name + " получает " + currentDamage + " урона!", msg.getUserId());
        }
        if (target.isDead())
        {
            this.getExperience(target, msg);
            new VKManager().sendMessage(target.name + " больше не двигается!", msg.getUserId());
        }
        else
        {
            new VKManager().sendMessage("У " + target.name + " осталось " + target.currentHealth + " очков здоровья!", msg.getUserId());
        }
    }

    public void changeCharacter(Character anotherCharacter)
    {
        this.name = anotherCharacter.name;
        this.level = anotherCharacter.level;
        this.maximumHealth = anotherCharacter.maximumHealth;
        this.currentHealth = anotherCharacter.currentHealth;
        this.maximalDamage = anotherCharacter.maximalDamage;
        this.minimalDamage = anotherCharacter.minimalDamage;
        this.criticalChance = anotherCharacter.criticalChance;
        this.damageReduction = anotherCharacter.damageReduction;
        this.evasionChance = anotherCharacter.evasionChance;
        this.experience = anotherCharacter.experience;
    }

    private Character chooseRandomTarget(Character[] targets)
    {
        Random random = new Random();
        return targets[random.nextInt(targets.length)];
    }

    public void makeAITurn(Character[] targets, Message msg) throws InterruptedException {
        Character target = chooseRandomTarget(targets);
        this.attack(target, msg);
    }
}