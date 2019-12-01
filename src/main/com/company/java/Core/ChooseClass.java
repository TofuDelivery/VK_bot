package main.com.company.java.Core;

import com.vk.api.sdk.objects.messages.Message;
import main.com.company.java.Classes;
import main.com.company.java.vkconfig.VKManager;

public class ChooseClass extends Command
{

    @Override
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
            new VKManager().sendKeyboardWithTwoButtons("Готовы начать ваше приключение?","Да", "Нет", message.getUserId());
            game.setState(2);
            game.player.changeCharacter(Classes.characters.get(choice));

        }
    }
}
