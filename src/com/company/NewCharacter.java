package com.company;

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

    private void GetExperience(NewCharacter target)
    {
        this.experience += target.experience;
        if (this.experience >= experienceForLevelUp[this.level - 1])
            this.LevelUp();
    }

    private void LevelUp()
    {
        this.level++;
        this.maximumHealth += (int)(this.maximumHealth / 10);
        this.currentHealth = this.maximumHealth;
        this.maximalDamage += (int)(this.maximalDamage / 10);
        this.minimalDamage += (int)(this.minimalDamage / 10);
        this.criticalChance += (int)(this.criticalChance / 10);
        this.damageReduction += (int)(this.damageReduction / 10);
        this.evasionChance += (int)(this.evasionChance / 10);
        System.out.println(this.name + " достигает " + this.level + " уровня!");
    }

    public boolean IsAlive()
    {
        return this.currentHealth > 0;
    }

    private void RestoreHealth()
    {
        this.currentHealth = this.maximumHealth;
    }

    private void Attack(NewCharacter target)
    {
        var random = new Random();
        var currentDamage = random.nextInt(this.maximalDamage - this.minimalDamage) + minimalDamage;
        var currentCritChance = random.nextInt(100) + 1;
        if (currentCritChance <= this.criticalChance)
        {
            currentDamage *= 2;
            System.out.println("Критический удар!");

        }
        var currentEvasionChance = random.nextInt(100) + 1;
        if (currentEvasionChance <= target.evasionChance)
        {
            System.out.println(target.name + " уклоняется!");
            return;
        }
        else
        {
            currentDamage = currentDamage * (100 - target.damageReduction) / 100;
            target.currentHealth -= currentDamage;
            System.out.println(target.name + " получает " + currentDamage + " урона!");
        }
        if (!target.IsAlive())
        {
            this.GetExperience(target);
            System.out.println(target.name + " больше не двигается!");
        }
        else
            {
                System.out.println("У " + target.name + " осталось " + target.currentHealth + "очков здоровья!");
            }
    }

    public void Fight(NewCharacter enemy) throws InterruptedException
    {
        while(this.IsAlive() && enemy.IsAlive())
        {
            this.Attack(enemy);
            Thread.sleep(2000);
            if (enemy.IsAlive())
                enemy.Attack(this);
            Thread.sleep(2000);
        }
        if (this.IsAlive())
        {
            System.out.println("You won! Your current health is " + this.currentHealth);
            enemy.RestoreHealth();
        }
        else
            System.out.println("You lose!");
    }
}
