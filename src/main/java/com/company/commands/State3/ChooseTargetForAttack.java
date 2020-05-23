package com.company.commands.State3;

import com.company.commands.ChooseOneEnemy;
import com.company.commands.Command;
import com.company.commands.Game;
import com.vk.api.sdk.objects.messages.Message;

public class ChooseTargetForAttack implements Command
{
    public void exec(Game game, Message message) throws NullPointerException, InterruptedException
    {
        new ChooseOneEnemy().exec(game, message);
        game.setState(3, 1);
    }
}

