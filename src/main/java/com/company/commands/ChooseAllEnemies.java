package com.company.commands;

import com.company.vkconfig.VKManager;
import com.vk.api.sdk.objects.messages.Message;

import java.util.ArrayList;

public class ChooseAllEnemies implements Command {
    @Override
    public void exec(Game game, Message message) throws NullPointerException, InterruptedException
    {
        var enemies = new ArrayList<String>();
        enemies.add("Все враги");
        new VKManager().sendKeyBoard("Выберите цель", message.getPeerId(), enemies);
    }
}
