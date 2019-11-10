package main.com.company.java.Core;

import com.vk.api.sdk.objects.messages.Message;

public class Attack extends Command {

    public Attack(int state, String name){
        super(state, name);
    }
    @Override
    public void exec(Message message) {

    }
}
