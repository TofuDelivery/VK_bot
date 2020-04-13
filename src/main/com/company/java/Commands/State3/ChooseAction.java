package main.com.company.java.Commands.State3;

import com.vk.api.sdk.objects.messages.Message;
import main.com.company.java.Commands.*;
import main.com.company.java.vkconfig.VKManager;

public class ChooseAction implements Command {
    public void exec(Game game, Message message) throws NullPointerException, InterruptedException
    {
        var action = message.getBody();
        if(action.equals("Атаковать"))
            new ChooseTarget().exec(game, message);
        else if (action.equals("Пить зелье"))
            new SelectPotion().exec(game, message);
        else if(action.equals("Убегать"))
            new Escape().exec(game, message);
        else
            new VKManager().sendMessage("Неправильная команда, попробуйте еще раз", message.getUserId());
    }
}
