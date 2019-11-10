
package main.com.company.java;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Message;
import main.com.company.java.vkconfig.VKCore;
import main.com.company.java.vkconfig.VKManager;

import java.util.Random;

public class NewCharacter
{
    String name;
    int level;
    int maximumHealth;
    int currentHealth;
    int maximalDamage;
    int minimalDamage;
    int criticalChance;
    int damageReduction;
    int evasionChance;
    int experience;
    static int[] experienceForLevelUp = {1000, 2000, 3000, 5000};

    public NewCharacter(String name, int level, int health, int maximalDamage, int minimalDamage, int criticalChance, int damageReduction, int evasionChance, int experience)
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

    private void getExperience(NewCharacter target, Message msg)
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

    public void attack(NewCharacter target, Message msg)
    {
        var random = new Random();
        var currentDamage = random.nextInt(this.maximalDamage - this.minimalDamage) + minimalDamage;
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

    public void fight(NewCharacter enemy, Message msg) throws InterruptedException
    {
        while(this.isAlive() && enemy.isAlive())
        {
            this.attack(enemy, msg);
            Thread.sleep(2000);

            if (enemy.isAlive())
                enemy.attack(this, msg);
            Thread.sleep(2000);
        }
        if (this.isAlive() && this.level != 5)
        {
            new VKManager().sendMessage("You won! Your current health is " + this.currentHealth, msg.getUserId());
            enemy.restoreHealth();
        }
        else
            new VKManager().sendMessage("You lose!", msg.getUserId());
    }

    public void changeCharacter(NewCharacter anotherCharacter)
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

    public void makeTurn(NewCharacter[] enemies, Message msg) throws NullPointerException, ApiException, ClientException
    {
        NewCharacter target = chooseTarget(enemies, msg);
        this.attack(target, msg);
    }

    private NewCharacter chooseTarget(NewCharacter[] targets, Message msg) throws NullPointerException, ApiException, ClientException
    {
        new VKManager().sendMessage("Выберите цель для атаки", msg.getUserId());
        Integer i = 1;
        for(NewCharacter target : targets)
        {
            System.out.println(i.toString() + target.name);
            i++;
        }
        while(true)
        {
            Integer choice = Integer.parseInt(String.valueOf(new VKCore().getMessage().getBody()));
            if(choice < 0 || choice >= targets.length)
            {
                new VKManager().sendMessage("Некорректный ввод. Попробуйте снова", msg.getUserId());
            }
            else
                {
                    return targets[choice];
                }
        }

    }

    private NewCharacter chooseRandomTarget(NewCharacter[] targets)
    {
        Random random = new Random();
        return targets[random.nextInt(targets.length)];
    }

    public void makeAITurn(NewCharacter[] targets, Message msg)
    {
        NewCharacter target = chooseRandomTarget(targets);
        this.attack(target, msg);
    }
}