
package com.company;

import com.company.vkconfig.VKManager;
import com.vk.api.sdk.objects.messages.Message;

import java.util.Random;

public class Character
{
    public String name;
    public int level;
    public int maximumHealth;
    public int currentHealth;
    public int maximumEnergy;
    public int currentEnergy;
    public int maximalDamage;
    public int minimalDamage;
    public int criticalChance;
    public int damageReduction;
    public int evasionChance;
    public int experience;
    int id;
    public PotionInventory potions;
    public AbilitiesList abilitiesList;
    public Character currentTarget;
    public Ability currentAbility;
    static int[] experienceForLevelUp = {1000, 2000, 3000, 5000};

    public Character()
    {
        this.name = "default";
        this.potions = new PotionInventory(this);
    }

    public Character(String name, int id, int level, int health, int maximalDamage, int minimalDamage, int criticalChance, int damageReduction, int evasionChance, int experience)
    {
        this.name = name;
        this.level = level;
        this.maximumHealth = health;
        this.currentHealth = this.maximumHealth;
        this.currentEnergy = this.maximumEnergy;
        this.maximalDamage = maximalDamage;
        this.minimalDamage = minimalDamage;
        this.criticalChance = criticalChance;
        this.damageReduction = damageReduction;
        this.evasionChance = evasionChance;
        this.experience = experience;
        this.id = id;
        this.potions = new PotionInventory(this);
        this.abilitiesList = new AbilitiesList(this);
    }

    public Character(String name, int id, int level, int health, int energy, int maximalDamage, int minimalDamage, int criticalChance, int damageReduction, int evasionChance, int experience)
    {
        this.name = name;
        this.level = level;
        this.maximumHealth = health;
        this.currentHealth = this.maximumHealth;
        this.maximumEnergy = energy;
        this.currentEnergy = this.maximumEnergy;
        this.maximalDamage = maximalDamage;
        this.minimalDamage = minimalDamage;
        this.criticalChance = criticalChance;
        this.damageReduction = damageReduction;
        this.evasionChance = evasionChance;
        this.experience = experience;
        this.id = id;
        this.potions = new PotionInventory(this);
        this.abilitiesList = new AbilitiesList(this);
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
        this.maximumHealth += this.maximumHealth / 10;
        this.currentHealth = this.maximumHealth;
        this.maximumEnergy += this.maximumEnergy / 10;
        this.currentEnergy = this.maximumEnergy;
        this.maximalDamage += this.maximalDamage / 10;
        this.minimalDamage += this.minimalDamage / 10;
        this.criticalChance += this.criticalChance / 10;
        this.damageReduction += this.damageReduction / 10;
        this.evasionChance += this.evasionChance / 10;
        new VKManager().sendMessage("********" + this.name + " достигает " + this.level + " уровня!" + "********", msg.getPeerId());
    }

    public boolean isAlive()
    {
        return this.currentHealth > 0;
    }

    public void restoreHealth()
    {
        this.currentHealth = this.maximumHealth;
    }

    public void attack(Character target, Message message) throws InterruptedException {
        new VKManager().sendMessage(this.name + " атакует!", message.getPeerId());
        var random = new Random();
        var criticalFlag = false;
        var evasionFlag = false;
        var currentMessage = "";
        var currentDamage = random.nextInt(this.maximalDamage - this.minimalDamage + 1) + minimalDamage;
        var currentCritChance = random.nextInt(100) + 1;
        if (currentCritChance <= this.criticalChance)
        {
            currentDamage *= 2;
            currentMessage += "Критический удар!\n";
            criticalFlag = true;
        }
        var currentEvasionChance = random.nextInt(100) + 1;
        if (currentEvasionChance <= target.evasionChance && !criticalFlag)
        {
            currentMessage += target.name + " уклоняется!\n";
        }
        else
        {
            currentDamage = currentDamage * (100 - target.damageReduction) / 100;
            target.receiveDamage(currentDamage);
            currentMessage += target.name + " получает " + currentDamage + " урона!\n";
        }
        if (target.isDead())
        {
            this.getExperience(target, message);
            currentMessage += target.name + " больше не двигается!\n";
        }
        else
        {
            currentMessage += "У " + target.name + " осталось " + target.currentHealth + " очков здоровья!\n";
        }
        new VKManager().sendMessage(currentMessage, message.getPeerId());
    }

    public void receiveDamage(int damage)
    {
        this.currentHealth -= damage;
    }

    public void changeCharacter(Character anotherCharacter)
    {
        this.name = anotherCharacter.name;
        this.level = anotherCharacter.level;
        this.maximumHealth = anotherCharacter.maximumHealth;
        this.currentHealth = anotherCharacter.currentHealth;
        this.maximumEnergy = anotherCharacter.maximumEnergy;
        this.currentEnergy = anotherCharacter.currentEnergy;
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