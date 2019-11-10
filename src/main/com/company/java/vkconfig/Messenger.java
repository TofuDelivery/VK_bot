package main.com.company.java.vkconfig;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Message;
import main.com.company.java.Core.Commander;

public class Messenger  implements Runnable {

    private Message message;

    public Messenger(Message message, int state){
        this.message = message;
    }

    @Override
    public void run() throws NullPointerException, ApiException, ClientException, InterruptedException
    {
      Commander.execute(message);
    }
}
