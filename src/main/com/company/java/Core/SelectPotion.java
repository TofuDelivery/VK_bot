package main.com.company.java.Core;

import com.vk.api.sdk.objects.messages.Message;
import main.com.company.java.vkconfig.VKManager;

public class SelectPotion extends Command
{
    @Override
    public void exec(Game game, Message message) throws NullPointerException, InterruptedException
    {
        if(game.player.potions.count == 0)
            new VKManager().sendMessage("У вас нет никаких зелий", message.getUserId());
        else
            {
        var msg = "Выберите зелье\nВаш список зелий:";
        for(var i = 0; i < game.player.potions.count; i++)
            msg += "\n" + (i+1) + ") " + game.player.potions.potions[i].name;
        new VKManager().sendMessage(msg, message.getUserId());
        game.setState(9);
        }
    }
}