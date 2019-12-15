package main.com.company.java.Core;

import com.vk.api.sdk.objects.messages.Message;
import main.com.company.java.vkconfig.VKManager;
import main.com.company.java.vkconfig.VKServer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Start extends Command {

    @Override
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
            game.setState(1);
        }
        else
        {
            new VKManager().sendMessage("Привет-привет. Чтобы начать игру, введите start", message.getUserId());
        }
    }
}
