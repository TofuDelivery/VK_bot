package com.company.commands.State4;

import com.company.Inventory.CoinsPouch;
import com.company.Trader.Price;
import com.vk.api.sdk.objects.messages.Message;
import com.company.commands.Command;
import com.company.commands.Game;
import com.company.vkconfig.VKManager;

import java.util.ArrayList;

public class BuyPotion implements Command {

    @Override
    public void exec(Game game, Message message) throws NullPointerException, InterruptedException {
        var potion = message.getText();
        var good = game.trader.sellGood(potion);
        var playerCoins = game.player.inventory.getCoins();
        if(checkPrice(playerCoins, good.getPrice())) {
            game.player.inventory.getPotions().addPotion(good.getPotion());
           playerCoins.addGold(-good.getPrice().getGold());
           playerCoins.addSilver(-good.getPrice().getSilver());
           playerCoins.addCopper(-good.getPrice().getCobber());
            new VKManager().sendMessage("Вы купили: " + message.getText(), message.getPeerId());
        }else new VKManager().sendMessage("У вас не достаточно денег", message.getPeerId());
        new VKManager().sendKeyBoard("Куда хотите отправиться?", message.getPeerId(), new ArrayList<>() {{
            add("Деревня");
            add("Приключение");
        }});
        game.setState(5, 0);
    }

    private boolean checkPrice(CoinsPouch coins, Price price){
        return price.getGold() <= coins.getGold() && price.getSilver() <= coins.getSilver() && price.getCobber() <= coins.getCopper();
    }
}
