package main.com.company.java.Commands;

import com.vk.api.sdk.objects.messages.Message;
import main.com.company.java.vkconfig.VKManager;

public class Exit extends Command
{
    @Override
    public void exec(Game game, Message message)
    {
        new VKManager().sendMessage("Game over!", message.getUserId());
        game.setState(0, 0);
    }
}
