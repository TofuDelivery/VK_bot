package com.company;

public class NewEnemies
{
    private static NewCharacter[] enemies = {
            new NewCharacter("Hedgehog", 1, 10, 0, 0, 0, 0, 0, 10),
            new NewCharacter("Rat", 1, 6, 4, 1, 10, 0, 10, 40),
            new NewCharacter("Wolf", 1, 20, 6, 4, 5, 0, 0, 100),
            new NewCharacter("Boar", 1, 30, 6, 1, 0, 10, 0, 150),
            new NewCharacter("Goblin", 1, 15, 8, 3, 10, 0, 0, 150),
            new NewCharacter("Cobold", 1, 25, 8, 5, 5, 0, 5, 200),
            new NewCharacter("Gnoll", 1, 30, 6, 4, 5, 5, 0, 200),
            new NewCharacter("Little Ooze", 1, 20, 3, 1, 0, 0, 0, 200),
            new NewCharacter("Sсelet", 1, 35, 8, 7, 0, 10, 0, 300),
            new NewCharacter("Rogue", 1, 40, 10, 2, 10, 0, 10, 300),
            new NewCharacter("Zombie", 1, 40, 10, 6, 5, 0, 0, 350),
            new NewCharacter("Orc", 1, 60, 8, 4, 5, 5, 0, 400),
            new NewCharacter("Ooze", 1, 60, 5, 1, 0, 0, 0, 400),
            new NewCharacter("GIANT ENEMY CRAB", 1, 70, 4, 1, 0, 10, 0, 500),
            new NewCharacter("Giant Poisonous Snake", 1, 40, 10, 4, 10, 0, 20, 500),
            new NewCharacter("Ghost", 1, 10, 10, 5, 0, 0, 90, 600),
            new NewCharacter("Hobgoblin", 1, 50, 12, 4, 5, 0, 5, 600),
            new NewCharacter("Giant Spider", 1, 70, 12, 2, 0, 15, 0, 800),
            new NewCharacter("Centaur", 1, 50, 15, 5, 10, 5, 5, 800),
            new NewCharacter("Giant Scorpion", 1, 70, 20, 10, 0, 5, 0, 1000),
            new NewCharacter("Giant Ooze", 1, 100, 10, 1, 0, 10, 0, 1000),
            new NewCharacter("UNSTOPPABLE EXODIA", 1000, 1000, 2000, 1000, 100, 100, 0, 0)
    };

    public static NewCharacter ChooseEnemy(int number)
    {
        return enemies[number];
    }
}
