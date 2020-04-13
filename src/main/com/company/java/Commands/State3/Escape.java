package main.com.company.java.Commands.State3;

import com.vk.api.sdk.objects.messages.Message;
import main.com.company.java.Commands.Command;
import main.com.company.java.Commands.Exit;
import main.com.company.java.Commands.Game;
import main.com.company.java.vkconfig.VKManager;

import java.util.Random;

public class Escape implements Command {
    public void exec(Game game, Message message) throws NullPointerException, InterruptedException
    {
        var chance = new Random().nextInt(100) + 1;
        if (chance > 30)
        {
            new VKManager().sendMessage("Вы успешно сбежали.", message.getUserId());
            new Exit().exec(game, message);
        }
        else
            {
                new VKManager().sendMessage("Вы не смогли сбежать.", message.getUserId());

                new EnemyTurn().exec(game, message);
            }
    }
}
