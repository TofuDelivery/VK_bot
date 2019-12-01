package main.com.company.java.Core;

import com.vk.api.sdk.objects.messages.Message;
import main.com.company.java.vkconfig.VKManager;
import main.com.company.java.vkconfig.VKServer;

public class Start extends Command {

    @Override
    public void exec(Game game, Message message)
    {
        if(message.getBody().equals("start"))
        {
            new VKManager().sendMessage("Игра началась!", message.getUserId());
            new VKManager().sendSticker(message.getUserId());
            new VKManager().sendKeyBoardWithThreeButtons("Выберите класс","Мечник", "Ассассин", "Заклинатель", message.getUserId());
            game.setState(1);
        }
        else
        {
            new VKManager().sendMessage("Привет-привет. Чтобы начать игру, введите start", message.getUserId());
        }
    }
}
