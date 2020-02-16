package main.com.company.java.Commands.State3;

import com.vk.api.sdk.objects.messages.Message;
import main.com.company.java.Commands.Command;
import main.com.company.java.Commands.Game;
import main.com.company.java.Potion;
import main.com.company.java.vkconfig.VKManager;

public class DrinkPotion extends Command
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

    @Override
    public void exec(Game game, Message message) throws NullPointerException, InterruptedException
    {
            var player = game.player;
            var currentHealth = player.currentHealth;
            var choice = getChoice(message.getBody(), game.player.potions.potions);
            var currentPotion = game.player.potions.potions[choice].getName();
            game.player.potions.consume(choice);
            var healedHealth = player.currentHealth - currentHealth;
            new VKManager().sendMessage("Вы использовали " + currentPotion + " и восстановили " + healedHealth + "очков здоровья!", message.getUserId());

            new EnemyTurn().exec(game, message);
    }
}
