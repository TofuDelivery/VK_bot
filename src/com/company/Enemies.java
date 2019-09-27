package com.company;

public class Enemies
{
     private Character[] enemies = {
            new Character("Hedgehog", 1, 0),
            new Character("Small Rat", 6, 1),
            new Character("Big Rat", 7, 2),
            new Character("Ooze", 20, 1),
            new Character("Typical Goblin", 20, 6),
            new Character("Big Bad Wolf", 30, 4),
            new Character("Random Rogue", 30, 6),
            new Character("Orc", 40, 4),
            new Character("GIANT ENEMY CRAB", 50, 1),
            new Character("UNSTOPPABLE EXODIA", 1000, 1000)
     };

     public Character ChooseEnemy(int number)
     {
         return enemies[number];
     }
}
