package com.company.vkconfig;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Message;
import com.company.commands.Commands;
import com.company.commands.Game;
import com.company.Character;
import com.company.Trader;

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
                    if(!games.containsKey(message.getPeerId()))
                        games.put(message.getPeerId(), new Game(defaultChar, null, new Trader()));
                    Commands.pool.get(games.get(message.getPeerId()).state).exec(games.get(message.getPeerId()), message);
                }
                Thread.sleep(333);
            }catch(ClientException e){
                System.out.println("Возникли проблемы");
                final int RECONNECT_TIME = 10000;
                System.out.println("Повторное соединение через" + RECONNECT_TIME);
                Thread.sleep(RECONNECT_TIME);
            }
        }
    }
}
