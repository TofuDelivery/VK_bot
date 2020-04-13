package main.com.company.java.Commands.State3;

import com.vk.api.sdk.objects.messages.Message;
import main.com.company.java.Commands.Command;
import main.com.company.java.Commands.Game;
import main.com.company.java.vkconfig.VKManager;

import java.util.ArrayList;

public class SelectPotion implements Command
{
    public void exec(Game game, Message message) throws NullPointerException, InterruptedException
    {
        if(game.player.potions.count == 0){
            new VKManager().sendMessage("У вас нет никаких зелий", message.getUserId());
            game.setState(3, 0);
        }
        else {
        var msg = "Выберите зелье";
        var buttonTexts = new ArrayList<String>();
        for(var i = 0; i < game.player.potions.count; i++)
            buttonTexts.add(game.player.potions.potions[i].getName());
        new VKManager().sendKeyBoard(msg, message.getUserId(), buttonTexts);
        game.setState(3, 3);
        }
    }
}