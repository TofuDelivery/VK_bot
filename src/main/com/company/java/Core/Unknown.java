package main.com.company.java.Core;

import com.vk.api.sdk.objects.messages.Message;
import main.com.company.java.vkconfig.VKManager;

public class Unknown extends Command {

    public Unknown(int state, String name) {
        super(state, name);
    }

    @Override
    public void exec(Message message) {
        new VKManager().sendMessage("Неизвестная команда", message.getUserId());
    }
}
