package main.com.company.java.Commands.State4;

import com.vk.api.sdk.objects.messages.Message;
import main.com.company.java.Commands.Command;
import main.com.company.java.Commands.Game;
import main.com.company.java.vkconfig.VKManager;

import java.util.ArrayList;

public class BuyPotion implements Command {

    @Override
    public void exec(Game game, Message message) throws NullPointerException, InterruptedException {
        game.player.potions.addPotion(game.trader.sellPotion(message.getBody()));
        new VKManager().sendMessage("Вы купили: " + message.getBody(), message.getUserId() ) ;
        new VKManager().sendKeyBoard("Куда хотите отправиться?", message.getUserId(), new ArrayList<>(){{ add("Деревня"); add("Приключение");}});
        game.setState(5, 0);
    }
}
