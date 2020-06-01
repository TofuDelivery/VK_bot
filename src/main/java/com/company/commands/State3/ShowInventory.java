package com.company.commands.State3;

import com.company.commands.Command;
import com.company.commands.Game;
import com.company.vkconfig.VKManager;
import com.vk.api.sdk.objects.messages.Message;


public class ShowInventory implements Command {
    @Override
    public void exec(Game game, Message message){
        new VKManager().sendMessage(game.player.inventory.getStringInventory(), message.getPeerId());
    }
}
