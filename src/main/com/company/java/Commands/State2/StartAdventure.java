package main.com.company.java.Commands.State2;

import com.vk.api.sdk.objects.messages.Message;
import main.com.company.java.Combat;
import main.com.company.java.Commands.Command;
import main.com.company.java.Commands.Game;
import main.com.company.java.vkconfig.VKManager;

public class StartAdventure extends Command
{
    @Override
    public void exec(Game game, Message msg) throws InterruptedException {
        if(msg.getBody().equals("Да"))
        {
            Combat.chooseCurrentEnemy(game, msg);
            game.setState(3, 0);
        }
        else
        {
            new VKManager().sendMessage("Когда будете готовы, нажмите \"Да\"", msg.getUserId());
            new VKManager().sendKeyboardWithTwoButtons("Готовы начать ваше приключение?","Да", "Нет", msg.getUserId());
        }
    }
}
