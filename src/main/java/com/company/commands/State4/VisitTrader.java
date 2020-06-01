package com.company.commands.State4;

import com.company.Trader.Good;
import com.vk.api.sdk.objects.messages.Message;
import com.company.commands.Command;
import com.company.commands.Game;
import com.company.vkconfig.VKManager;

import java.util.ArrayList;

public class VisitTrader implements Command {

    @Override
    public void exec(Game game, Message message) throws NullPointerException, InterruptedException {
        var goods = game.trader.getGoods();
        StringBuilder builder = new StringBuilder();
        builder.append("Мои товары:\n");
        for (Good good : goods.values()){
            builder.append(good.getPotion().getName());
            builder.append(" : ");
            builder.append(good.getPrice().getStrPrice());
            builder.append("\n");
        }
        new VKManager().sendMessage(builder.toString(), message.getPeerId());
        new VKManager().sendKeyBoard("Какое зелье вы хотите купить?", message.getPeerId(), new ArrayList<>(goods.keySet()));
        game.setState(4, 0);

    }
}
