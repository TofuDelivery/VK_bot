package com.company.commands.State2;

import com.vk.api.sdk.objects.messages.Message;
import com.company.Combat;
import com.company.commands.Command;
import com.company.commands.Game;
import com.company.commands.State4.VisitTrader;
import com.company.vkconfig.VKManager;

import java.util.ArrayList;

public class StartAdventure implements Command
{
    public void exec(Game game, Message msg) throws InterruptedException {
        if(msg.getText().equals("Отправиться в приключение"))
        {
            Combat.chooseCurrentEnemy(game, msg);
            game.setState(3, 0);
        }
        else if (msg.getText().equals("Посетить торговца")){
            new VisitTrader().exec(game, msg);
        }
        else
        {
            new VKManager().sendMessage("Когда будете готовы, выберете действие", msg.getPeerId());
            new VKManager().sendKeyBoard("Вы попали на нейтральную территорию.\n Что вы хотите сделать?", msg.getPeerId(), new ArrayList<>(){{add("Отправиться в приключение"); add("Посетить торговца"); add("Закончить игру"); }});

        }
    }
}
