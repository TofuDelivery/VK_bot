package com.company;

import java.util.Scanner;

public class NewClasses
{
    private static NewCharacter[] characters = {
            new NewCharacter("Saber", 1, 100, 15, 10, 5, 10, 0, 0),
            new NewCharacter("Assassin", 1, 80, 20, 12, 20, 0, 5, 0),
            new NewCharacter("Caster", 1, 60, 30, 8, 10, 0, 0, 0)
    };

    public static NewCharacter chooseClass()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Choose your class - 1)Saber  2)Assassin 3)Caster");
        var choose = in.nextInt();
        if (choose <= characters.length && choose >= 0)
            return  characters[choose - 1];
        else {
            System.out.println("Incorrect input, try again");
            System.exit(1);
            return null;
        }
    };
}
