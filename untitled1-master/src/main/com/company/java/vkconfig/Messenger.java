package main.com.company.java.vkconfig;

import com.vk.api.sdk.objects.messages.Message;
import main.com.company.java.Core.Commander;

public class Messenger  implements Runnable{

    private Message message;

    public Messenger(Message message){
        this.message = message;
    }

    @Override
    public void run(){
      Commander.execute(message);
    }
}