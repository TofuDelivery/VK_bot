package com.company.commands.State5;

import com.vk.api.sdk.objects.messages.Message;
import com.company.Combat;
import com.company.commands.Command;
import com.company.commands.Game;
import com.company.vkconfig.VKManager;

import java.util.ArrayList;

public class VisitVillage implements Command {
    @Override
    public void exec(Game game, Message message) throws NullPointerException, InterruptedException {
        if (message.getText().equals("Деревня")){
            new VKManager().sendKeyBoard("Вы попали на нейтральную территорию.\n Что вы хотите сделать?", message.getPeerId(), new ArrayList<>(){{add("Отправиться в приключение"); add("Посетить торговца"); add("Закончить игру"); }});
            game.setState(2,0);
        }
        else{
            Combat.chooseCurrentEnemy(game, message);
            game.setState(3, 0);
        }
    }
}
