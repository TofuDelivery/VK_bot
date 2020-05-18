package com.company.commands.State4;

import com.vk.api.sdk.objects.messages.Message;
import com.company.commands.Command;
import com.company.commands.Game;
import com.company.vkconfig.VKManager;

import java.util.ArrayList;

public class VisitTrader implements Command {

    @Override
    public void exec(Game game, Message message) throws NullPointerException, InterruptedException {
        var goods = game.trader.getPotions();
        new VKManager().sendKeyBoard("Какое зелье вы хотите купить?", message.getPeerId(), new ArrayList<>(goods.keySet()));
        game.setState(4, 0);

    }
}
