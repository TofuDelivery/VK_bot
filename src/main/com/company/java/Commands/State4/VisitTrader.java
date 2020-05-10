package main.com.company.java.Commands.State4;

import com.vk.api.sdk.objects.messages.Message;
import main.com.company.java.Commands.Command;
import main.com.company.java.Commands.Game;
import main.com.company.java.vkconfig.VKManager;

import java.util.ArrayList;

public class VisitTrader implements Command {

    @Override
    public void exec(Game game, Message message) throws NullPointerException, InterruptedException {
        var goods = game.trader.getPotions();
        new VKManager().sendKeyBoard("Какое зелье вы хотите купить?", message.getUserId(), new ArrayList<>(goods.keySet()));
        game.setState(4, 0);

    }
}
