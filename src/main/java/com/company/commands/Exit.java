package com.company.commands;

import com.vk.api.sdk.objects.messages.Message;
import com.company.vkconfig.VKManager;

public class Exit implements Command
{
    @Override
    public void exec(Game game, Message message)
    {
        new VKManager().sendMessage("Game over!", message.getPeerId());
        game.setState(0, 0);
    }
}
