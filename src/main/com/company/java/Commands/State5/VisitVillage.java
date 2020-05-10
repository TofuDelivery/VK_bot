package main.com.company.java.Commands.State5;

import com.vk.api.sdk.objects.messages.Message;
import main.com.company.java.Combat;
import main.com.company.java.Commands.Command;
import main.com.company.java.Commands.Game;
import main.com.company.java.vkconfig.VKManager;

import java.util.ArrayList;

public class VisitVillage implements Command {
    @Override
    public void exec(Game game, Message message) throws NullPointerException, InterruptedException {
        if (message.getBody().equals("Деревня")){
            new VKManager().sendKeyBoard("Вы попали на нейтральную территорию.\n Что вы хотите сделать?", message.getUserId(), new ArrayList<>(){{add("Отправиться в приключение"); add("Посетить торговца"); add("Закончить игру"); }});
            game.setState(2,0);
        }
        else{
            Combat.chooseCurrentEnemy(game, message);
            game.setState(3, 0);
        }
    }
}
