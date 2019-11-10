package main.com.company.java;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Message;
import main.com.company.java.vkconfig.VKManager;

public class Combat
{
    private static boolean isPartyAlive(NewCharacter[] characters)
    {
        for(NewCharacter character : characters)
        {
            if(character.isAlive())
                return true;
        }
        return false;
    }


    //public void
    public static void fight(NewCharacter player, NewCharacter enemy, Message msg) throws NullPointerException, InterruptedException
    {
        NewCharacter[] enemies = new NewCharacter[]{enemy};
        NewCharacter[] players = new NewCharacter[]{player};
        while(player.isAlive() && enemy.isAlive())
        {
            player.makeTurn(enemies, msg);
            Thread.sleep(2000);
            if(enemy.isAlive())
                enemy.makeAITurn(players, msg);
            Thread.sleep(2000);
        }
        if (player.isAlive() && player.level != 5)
        {
            new VKManager().sendMessage("You won! Your current health is " + player.currentHealth, msg.getUserId());
            enemy.restoreHealth();
        }
        else
        new VKManager().sendMessage("Game over", msg.getUserId());
    }
}
