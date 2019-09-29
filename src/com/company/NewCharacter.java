package com.company;

import java.util.Random;

public class NewCharacter
{
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

    public NewCharacter(int level, int health, int maximalDamage, int minimalDamage, int criticalChance, int damageReduction, int evasionChance, int experience)
    {
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

    public void LevelUp()
    {
        this.level++;
        this.maximumHealth += (int)(this.maximumHealth / 10);
        this.currentHealth = this.maximumHealth;
        this.maximalDamage += (int)(this.maximalDamage / 10);
        this.minimalDamage += (int)(this.minimalDamage / 10);
        this.criticalChance += (int)(this.criticalChance / 10);
        this.damageReduction += (int)(this.damageReduction / 10);
        this.evasionChance += (int)(this.evasionChance / 10);
    }

    private boolean IsAlive()
    {
        return this.currentHealth > 0;
    }

    public void Attack(NewCharacter target)
    {
        var random = new Random();
        var currentDamage = random.nextInt(this.maximalDamage - this.minimalDamage) + minimalDamage;
        var currentCritChance = random.nextInt(100) + 1;
        if (currentCritChance <= this.criticalChance)
            currentDamage *= 2;
        var currentEvasionChance = random.nextInt(100) + 1;
        if (currentEvasionChance <= this.evasionChance)
            return;
        else
            target.currentHealth -= currentDamage;
        if (!target.IsAlive())
            this.GetExperience(target);
    }
}
