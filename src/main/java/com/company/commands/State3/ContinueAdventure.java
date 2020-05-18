package com.company.commands.State3;

import com.vk.api.sdk.objects.messages.Message;
import com.company.Combat;
import com.company.commands.Command;
import com.company.commands.Exit;
import com.company.commands.Game;

public class ContinueAdventure implements Command {
    public void exec(Game game, Message message) throws InterruptedException {
        if(message.getText().equals("Отправиться в приключение"))
        {
            Combat.chooseCurrentEnemy(game, message);
            game.setState(3, 0);
        }
        else if (message.getText().equals("Посетить торговца")){
            game.setState(3,2);
        }
        else
            {
                new Exit().exec(game, message);
            }
    }
}
