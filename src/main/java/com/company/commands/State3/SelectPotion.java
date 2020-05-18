package com.company.commands.State3;

import com.vk.api.sdk.objects.messages.Message;
import com.company.commands.Command;
import com.company.commands.Game;
import com.company.vkconfig.VKManager;

import java.util.ArrayList;

public class SelectPotion implements Command
{
    public void exec(Game game, Message message) throws NullPointerException, InterruptedException
    {
        if(game.player.potions.count == 0){
            new VKManager().sendMessage("У вас нет никаких зелий", message.getPeerId());
            game.setState(3, 0);
        }
        else {
        var msg = "Выберите зелье";
        var buttonTexts = new ArrayList<String>();
        for(var i = 0; i < game.player.potions.count; i++)
            buttonTexts.add(game.player.potions.potions[i].getName());
        new VKManager().sendKeyBoard(msg, message.getPeerId(), buttonTexts);
        game.setState(3, 3);
        }
    }
}