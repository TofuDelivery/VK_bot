package com.company.commands.State4;

import com.vk.api.sdk.objects.messages.Message;
import com.company.commands.Command;
import com.company.commands.Game;
import com.company.vkconfig.VKManager;

import java.util.ArrayList;

public class BuyPotion implements Command {

    @Override
    public void exec(Game game, Message message) throws NullPointerException, InterruptedException {
        game.player.potions.addPotion(game.trader.sellPotion(message.getText()));
        new VKManager().sendMessage("Вы купили: " + message.getText(), message.getPeerId() ) ;
        new VKManager().sendKeyBoard("Куда хотите отправиться?", message.getPeerId(), new ArrayList<>(){{ add("Деревня"); add("Приключение");}});
        game.setState(5, 0);
    }
}
