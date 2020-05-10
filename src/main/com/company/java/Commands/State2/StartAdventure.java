package main.com.company.java.Commands.State2;

import com.vk.api.sdk.objects.messages.Message;
import main.com.company.java.Combat;
import main.com.company.java.Commands.Command;
import main.com.company.java.Commands.Game;
import main.com.company.java.Commands.State4.VisitTrader;
import main.com.company.java.vkconfig.VKManager;

import java.util.ArrayList;

public class StartAdventure implements Command
{
    public void exec(Game game, Message msg) throws InterruptedException {
        if(msg.getBody().equals("Отправиться в приключение"))
        {
            Combat.chooseCurrentEnemy(game, msg);
            game.setState(3, 0);
        }
        else if (msg.getBody().equals("Посетить торговца")){
            new VisitTrader().exec(game, msg);
        }
        else
        {
            new VKManager().sendMessage("Когда будете готовы, выберете действие", msg.getUserId());
            //new VKManager().sendKeyboardWithTwoButtons("Готовы начать ваше приключение?","Да", "Нет", msg.getUserId());
            new VKManager().sendKeyBoard("Вы попали на нейтральную территорию.\n Что вы хотите сделать?", msg.getUserId(), new ArrayList<>(){{add("Отправиться в приключение"); add("Посетить торговца"); add("Закончить игру"); }});

        }
    }
}
