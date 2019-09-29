package main.com.company.java.Core;

import com.vk.api.sdk.objects.messages.Message;

public class Hello extends Command{

    public Hello(String name) {
        super(name);
    }

    @Override
    public void exec(Message message) {
        System.out.println("Привет");
    }
}
