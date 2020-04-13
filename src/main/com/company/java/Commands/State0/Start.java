package main.com.company.java.Commands.State0;

import com.vk.api.sdk.objects.messages.Message;
import main.com.company.java.Commands.Command;
import main.com.company.java.Commands.Game;
import main.com.company.java.vkconfig.VKManager;

import java.util.ArrayList;

public class Start implements Command {

    public void exec(Game game, Message message)
    {
        if(message.getBody().equals("start"))
        {
            new VKManager().sendMessage("Игра началась!", message.getUserId());
            new VKManager().sendSticker(message.getUserId());
            ArrayList<String> buttonTexts = new ArrayList<>();
            buttonTexts.add("Мечник");
            buttonTexts.add("Ассассин");
            buttonTexts.add("Заклинатель");
            new VKManager().sendKeyBoard("Выберите класс",message.getUserId(), buttonTexts);
            game.setState(1, 0);
        }
        else
        {
            new VKManager().sendMessage("Привет-привет. Чтобы начать игру, введите start", message.getUserId());
        }
    }
}
