package main.com.company.java.Core;

import com.vk.api.sdk.objects.messages.Message;
import main.com.company.java.Character;
import main.com.company.java.Combat;
import main.com.company.java.vkconfig.VKManager;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ChooseTarget extends Command
{

    @Override
    public void exec(Game game, Message message) throws NullPointerException, InterruptedException
    {
        if (message.getBody().equals("Убегать")) {
            new VKManager().sendMessage("Вы успешно спаслись!", message.getUserId());
            new VKManager().sendKeyboardWithTwoButtons("Хотите продолжать приключение?", "Да", "Нет", message.getUserId());
            game.setState(5);
        }else{
            var currentEnemies = new ArrayList<String>();
            for (var enemy : game.enemies.enemies) {
                if(enemy.isAlive()){
                    currentEnemies.add(enemy.name + " " + enemy.currentHealth + " % " + enemy.maximumHealth);
                }
            }
            new VKManager().sendKeyBoard("Выберите цель", message.getUserId(), currentEnemies);
            game.setState(4);
        }
    }
}
