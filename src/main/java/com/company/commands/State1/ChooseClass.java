package com.company.commands.State1;

import com.company.Classes;
import com.company.commands.Command;
import com.company.commands.Game;
import com.company.potions.MediumHealthPotion;
import com.company.potions.SmallHealthPotion;
import com.company.vkconfig.VKManager;
import com.vk.api.sdk.objects.messages.Message;

import java.util.ArrayList;

public class ChooseClass implements Command
{

    public void exec(Game game, Message message) throws NullPointerException
    {
        var choice = message.getText();

        if(!Classes.characters.containsKey(choice))
        {
            new VKManager().sendMessage("Некорректный выбор. Попробуйте еще разочек.", message.getPeerId());
        }
        else
        {
            new VKManager().sendMessage("Выбор сделан!", message.getPeerId());
            new VKManager().sendKeyBoard("Куда хотите отправиться?", message.getPeerId(), new ArrayList<>(){{ add("Деревня"); add("Приключение");}});
            game.player.changeCharacter(Classes.characters.get(choice));
            game.player.potions.addPotion(new SmallHealthPotion());
            game.player.potions.addPotion(new SmallHealthPotion());
            game.player.potions.addPotion(new MediumHealthPotion());
            //game.player.abilitiesList = new AbilitiesList(game.player);
            //game.player.abilitiesList.AddAbility(new Iceshard());
            game.setState(5, 0);
        }
    }
}
