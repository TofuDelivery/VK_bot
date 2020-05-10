package main.com.company.java.Commands.State1;

import com.vk.api.sdk.objects.messages.Message;
import main.com.company.java.Classes;
import main.com.company.java.Commands.Command;
import main.com.company.java.Commands.Game;
import main.com.company.java.Potions.MediumHealthPotion;
import main.com.company.java.Potions.SmallHealthPotion;
import main.com.company.java.vkconfig.VKManager;

import java.util.ArrayList;

public class ChooseClass implements Command
{

    public void exec(Game game, Message message) throws NullPointerException
    {
        var choice = message.getBody();

        if(!Classes.characters.containsKey(choice))
        {
            new VKManager().sendMessage("Некорректный выбор. Попробуйте еще разочек.", message.getUserId());
        }
        else
        {
            new VKManager().sendMessage("Выбор сделан!", message.getUserId());
            new VKManager().sendKeyBoard("Куда хотите отправиться?", message.getUserId(), new ArrayList<>(){{ add("Деревня"); add("Приключение");}});
            game.player.changeCharacter(Classes.characters.get(choice));
            game.player.potions.addPotion(new SmallHealthPotion());
            game.player.potions.addPotion(new SmallHealthPotion());
            game.player.potions.addPotion(new MediumHealthPotion());
            game.setState(5, 0);
        }
    }
}
