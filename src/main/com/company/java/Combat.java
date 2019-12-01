package main.com.company.java;

import com.vk.api.sdk.objects.messages.Message;
import main.com.company.java.Core.Game;
import main.com.company.java.vkconfig.VKManager;

import java.util.Random;

public class Combat
{
    public static boolean isPartyAlive(Character[] characters)
    {
        for(Character character : characters)
    {
        if(character.isAlive())
            return true;
    }
        return false;
    }

    public static void restoreParty(Character[] characters)
    {
        for(var deadEnemy : characters)
        {
            deadEnemy.restoreHealth();
        }
    }

    public static boolean isPartyDead(Character[] characters)
    {
        return !isPartyAlive(characters);
    }

    public static void chooseCurrentEnemy(Game game, Message msg) throws InterruptedException {
        var random = new Random();
        game.enemies = Enemies.ChooseEnemy(random.nextInt(Enemies.getCount()));
        new VKManager().sendMessage("На вашем пути появляется " +  game.enemies.name + "!" , msg.getUserId());
        new VKManager().sendKeyboardWithTwoButtons("Что будете делать?","Атаковать", "Убегать", msg.getUserId());
        Thread.sleep(1000);
    }
}
