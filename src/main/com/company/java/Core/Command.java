package main.com.company.java.Core;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Message;
import main.com.company.java.vkconfig.VKServer;

public  abstract class Command {

    static {}

    public abstract void exec(Game game, Message message) throws NullPointerException, InterruptedException;

}
