package main.com.company.java;

import java.util.Random;
import java.util.Scanner;

public class Adventure
{
    public static void Run() throws InterruptedException
    {
        Scanner in = new Scanner(System.in);
        var random = new Random();
        Character player = new Character(null, 0, 0);
        Classes classes = new Classes();
        Enemies enemies = new Enemies();
        classes.ChooseClass(player);
        while(player.IsAlive())
        {
            var enemy = enemies.ChooseEnemy(random.nextInt(10));
            System.out.println("Your enemy is " +  enemy.name + "!");
            Thread.sleep(1000);
            player.Fight(enemy);
            if (player.IsAlive())
            Thread.sleep(1000);
        }
    }
}
