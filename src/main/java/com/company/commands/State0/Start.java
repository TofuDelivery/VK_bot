package com.company.commands.State0;

import com.company.commands.Command;
import com.company.commands.Game;
import com.company.vkconfig.VKManager;
import com.vk.api.sdk.objects.messages.Message;

import java.util.ArrayList;

public class Start implements Command {

    public void exec(Game game, Message message)
    {
        if(message.getText().equals("start"))
        {
            new VKManager().sendMessage("Игра началась!", message.getPeerId());
            new VKManager().sendSticker(message.getPeerId());
            ArrayList<String> buttonTexts = new ArrayList<>();
            buttonTexts.add("Мечник");
            buttonTexts.add("Ассассин");
            buttonTexts.add("Заклинатель");
            new VKManager().sendKeyBoard("Выберите класс",message.getPeerId(), buttonTexts);
            game.setState(1, 0);
        }
        else
        {
            new VKManager().sendMessage("Привет-привет. Чтобы начать игру, введите start", message.getPeerId());
        }
    }
}
