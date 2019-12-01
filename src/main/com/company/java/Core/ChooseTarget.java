package main.com.company.java.Core;

import com.vk.api.sdk.objects.messages.Message;
import main.com.company.java.Character;
import main.com.company.java.vkconfig.VKManager;

public class ChooseTarget extends Command
{

    @Override
    public void exec(Game game, Message message) throws NullPointerException, InterruptedException
    {
        if (message.getBody().equals("Убегать")) {
            new Exit().exec(game, message);
        } else {
            var i = 1;
            new VKManager().sendMessage("Выберите цель", message.getUserId());
            for (var enemy : game.enemies.enemies) {
                if(enemy.isAlive())
                {
                    new VKManager().sendMessage(i + ")  " + enemy.name + "  [" + enemy.currentHealth + "\\" + enemy.maximumHealth + "]", message.getUserId());
                }
                i++;
            }
            game.setState(4);
        }
    }
}
