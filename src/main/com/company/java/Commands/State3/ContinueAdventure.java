package main.com.company.java.Commands.State3;

import com.vk.api.sdk.objects.messages.Message;
import main.com.company.java.Combat;
import main.com.company.java.Commands.Command;
import main.com.company.java.Commands.Exit;
import main.com.company.java.Commands.Game;

public class ContinueAdventure implements Command {
    public void exec(Game game, Message message) throws InterruptedException {
        if(message.getBody().equals("Отправиться в приключение"))
        {
            Combat.chooseCurrentEnemy(game, message);
            game.setState(3, 0);
        }
        else if (message.getBody().equals("Посетить торговца")){
            game.setState(3,2);
        }
        else
            {
                new Exit().exec(game, message);
            }
    }
}
