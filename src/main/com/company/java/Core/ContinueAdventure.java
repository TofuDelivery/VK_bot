package main.com.company.java.Core;

import com.vk.api.sdk.objects.messages.Message;
import main.com.company.java.Combat;
import main.com.company.java.vkconfig.VKServer;

public class ContinueAdventure extends Command {
    @Override
    public void exec(Game game, Message message) throws InterruptedException {
        if(message.getBody().equals("Да"))
        {
            Combat.chooseCurrentEnemy(game, message);
            game.setState(3);
        }
        else
            {
                new Exit().exec(game, message);
            }
    }
}
