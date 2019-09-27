package com.company;

import com.company.Character;

import java.util.Scanner;

public class Classes {
    private Character[] characters =  {
            new Character("Saber", 50, 6),
            new Character("Archer", 45, 7),
            new Character("Lancer", 60, 5)
    };

    public void ChooseClass(Character player){
        Scanner in = new Scanner(System.in);
        System.out.println("Choose your class - 1)Saber  2)Archer 3)Lancer");
        var choose = in.nextInt();
        if (choose <= characters.length && choose >= 0)
            player.ChangeCharacter(characters[choose - 1]);
        else
        {
            System.out.println("Incorrect input, try again");
            System.exit(1);
        }
    }
}
