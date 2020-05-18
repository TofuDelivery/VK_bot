package com.company;

import com.company.commands.Game;
import com.company.vkconfig.VKManager;
import com.vk.api.sdk.objects.messages.Message;

import java.util.ArrayList;
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
        new VKManager().sendMessage("На вашем пути появляется " +  game.enemies.name + "!" , msg.getPeerId());
        var buttonTexts = new ArrayList<String>();
        buttonTexts.add("Атаковать");
        buttonTexts.add("Убегать");
        buttonTexts.add("Пить зелье");
        new VKManager().sendKeyBoard("Что будете делать?", msg.getPeerId(), buttonTexts);

        Thread.sleep(1000);
    }
}
