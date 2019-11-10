package main.com.company.java.Core;

import com.vk.api.sdk.objects.messages.Message;
import main.com.company.java.vkconfig.VKManager;

public class Start extends Command {

    public Start(int state, String name) {
        super(state, name);

    }

    @Override
    public void exec(Message message) {
        new VKManager().sendMessage("Игра началась", message.getUserId());
        new VKManager().sendMessage("Choose your class - 1)Saber  2)Assassin 3)Caster", message.getUserId());
    }
}
