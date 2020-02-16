package main.com.company.java.vkconfig;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Message;
import main.com.company.java.Commands.Commands;
import main.com.company.java.Commands.Game;
import main.com.company.java.Character;

import java.util.HashMap;

public class VKServer {
    public  static VKCore vkCore;
    static {
        try{
            vkCore = new VKCore();
        } catch (ApiException | ClientException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws NullPointerException, ApiException, InterruptedException, ClientException {
        System.out.println(("Running server..."));
        var defaultChar = new Character("default", 0, 0, 0, 0, 0, 0, 0, 0, 0);
        var games = new HashMap<Integer, Game>();
        while (true)
        {
            try{
                Message message = vkCore.getMessage();
                if(message != null)
                {
                    if(!games.containsKey(message.getUserId()))
                        games.put(message.getUserId(), new Game(defaultChar, null));
                    Commands.pool.get(games.get(message.getUserId()).state).exec(games.get(message.getUserId()), message);
                }
            }catch(ClientException e){
                System.out.println("Возникли проблемы");
                final int RECONNECT_TIME = 10000;
                System.out.println("Повторное соединение через" + RECONNECT_TIME);
                Thread.sleep(RECONNECT_TIME);
            }
        }
    }
}
