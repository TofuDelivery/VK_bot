package com.company;

public class Bonus
{     int maximumHealthBonus;
    int maximalDamageBonus;
    int minimalDamageBonus;
    int criticalChanceBonus;
    int damageReductionBonus;
    int evasionChanceBonus;

    public Bonus(int maximumHealthBonus, int maximalDamageBonus, int minimalDamageBonus, int criticalChanceBonus, int damageReductionBonus, int evasionChanceBonus)
    {
        this.maximumHealthBonus = maximumHealthBonus;
        this.maximalDamageBonus = maximalDamageBonus;
        this.minimalDamageBonus = minimalDamageBonus;
        this.criticalChanceBonus = criticalChanceBonus;
        this.damageReductionBonus = damageReductionBonus;
        this.evasionChanceBonus = evasionChanceBonus;
    }

    public void GiveBonuses(NewCharacter character)
    {
        character.maximumHealth += maximumHealthBonus;
        character.maximalDamage += maximalDamageBonus;
        character.minimalDamage += minimalDamageBonus;
        character.criticalChance += criticalChanceBonus;
        character.damageReduction += damageReductionBonus;
        character.evasionChance += evasionChanceBonus;
    }
}
