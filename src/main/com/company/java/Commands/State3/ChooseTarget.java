package main.com.company.java.Commands.State3;

import com.vk.api.sdk.objects.messages.Message;
import main.com.company.java.Commands.Command;
import main.com.company.java.Commands.Game;
import main.com.company.java.vkconfig.VKManager;

import java.util.ArrayList;

public class ChooseTarget extends Command
{

    @Override
    public void exec(Game game, Message message) throws NullPointerException, InterruptedException
    {
        var currentEnemies = new ArrayList<String>();
        for (var enemy : game.enemies.enemies) {
            if(enemy.isAlive()){
                currentEnemies.add(enemy.name + " " + enemy.currentHealth + " % " + enemy.maximumHealth);
            }
        }
        new VKManager().sendKeyBoard("Выберите цель", message.getUserId(), currentEnemies);
        game.setState(3, 1);
    }
}

