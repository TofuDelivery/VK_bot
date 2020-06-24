package com.company.commands.State3;

import com.vk.api.sdk.objects.messages.Message;
import com.company.commands.Command;
import com.company.commands.Game;
import com.company.Potion;
import com.company.vkconfig.VKManager;

public class DrinkPotion implements Command
{

    private int getChoice(String msg, Potion[] potions)
    {
        for (var i = 0; i < potions.length; i++)
        {
            if (potions[i].getName().equals(msg))
            {
                return i;
            }
        }
        return -1;
    }

    public void exec(Game game, Message message) throws NullPointerException, InterruptedException
    {
        var player = game.player;
        var currentHealth = player.currentHealth;
        var inventory = game.player.inventory;
        var potionIndex = inventory.getPotion(message.getText());

        var potionName = inventory.consumePotion(potionIndex);
        var healedHealth = player.currentHealth - currentHealth;
        new VKManager().sendMessage("Вы использовали " + potionName + " и восстановили " + healedHealth + " очков здоровья!", message.getPeerId());

        new EnemyTurn().exec(game, message);
    }
}