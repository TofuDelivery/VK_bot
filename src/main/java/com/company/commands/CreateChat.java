/*package com.company.Core;

import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Message;
import com.company.vkconfig.VKCore;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class CreateChat extends Command {
    @Override
    public void exec(Message message) throws NullPointerException, InterruptedException {
        VKCore vKcore = null;
        try {
            vKcore = new VKCore();
        } catch (ClientException | ApiException e) {
            e.printStackTrace();
        }
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("src/main/com/company/java/vkconfig/properties"));
            var access_token = prop.getProperty("access_token");
            UserActor userActor = new UserActor(message.getPeerId(), access_token);
            var vkFriends = vKcore.getVk().friends();
            var users = message.getText().split(" ");
            for (String user : users){
                if vkFriends.a
            }
            var usersIds = new ArrayList<Integer>();
            for (String s : usersIdsStr) {
                usersIds.add(Integer.parseInt(s));
            }
            if (vKcore != null) {
                var chatId = vKcore.getVk().messages().createChat(userActor, usersIds).execute();
            }
        } catch (IOException | ClientException | ApiException e) {
            e.printStackTrace();
        }
    }
}*/
