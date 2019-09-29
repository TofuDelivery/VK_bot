package com.company;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

    @Test
    void isAlive()
    {
        var aliveCharacter = new Character("test", 10, 0);
        Assert.assertEquals(true, aliveCharacter.IsAlive());
        var deadCharacter = new Character("test", 0, 0);
        Assert.assertEquals(false, deadCharacter.IsAlive());
    }

    @Test
    void fight()
    {
        var character = new Character("test", 10, 5);
        var firstEnemy = Enemies.ChooseEnemy(0);
        character.Fight(firstEnemy);
        Assert.assertEquals(true, character.IsAlive());
        var secondEnemy = Enemies.ChooseEnemy(9);
        character.Fight(secondEnemy);
        Assert.assertEquals(false, character.IsAlive());
    }

    @Test
    void changeCharacter()
    {
        var firstCharacter = new Character("test", 10, 10);
        var secondCharacter = new Character("anotherTest", 20, 15);
        firstCharacter.ChangeCharacter(secondCharacter);
        Assert.assertEquals("anotherTest", firstCharacter.name);
        Assert.assertEquals(20, firstCharacter.maximumHealth);
        Assert.assertEquals(20, firstCharacter.currentHealth);
        Assert.assertEquals(15, firstCharacter.damage);
    }
}