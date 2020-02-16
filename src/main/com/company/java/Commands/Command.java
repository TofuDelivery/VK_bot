package main.com.company.java.Commands;

import com.vk.api.sdk.objects.messages.Message;

public  abstract class Command {

    static {}

    public abstract void exec(Game game, Message message) throws NullPointerException, InterruptedException;

}
