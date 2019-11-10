package main.com.company.java.Core;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Message;

public  abstract class Command {

    public final int state;
    public final String name;

    Command(int state, String name) {
        this.state = state;
        this.name = name;
    }

    public abstract void exec(Message message) throws NullPointerException, ApiException, ClientException, InterruptedException;

}
