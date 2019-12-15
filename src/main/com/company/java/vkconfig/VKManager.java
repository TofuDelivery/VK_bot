package main.com.company.java.vkconfig;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.users.UserXtrCounters;
import com.vk.api.sdk.queries.messages.MessagesSendQuery;

import java.util.ArrayList;

public class VKManager {

    public static VKCore vkCore;

    static {
        try{
            vkCore = new VKCore();
        } catch(ApiException | ClientException e){
            e.printStackTrace();
        }
    }

    public void sendMessage(String msg, int peerId){
        if (msg == null){
            System.out.println("null");
            return;
        }
        try {
            vkCore.getVk().messages().send(vkCore.getActor()).peerId(peerId).message(msg).execute();
        }catch (ApiException | ClientException e){
            e.printStackTrace();
        }
    }

    public void sendPicture(String photoId, int peerId){
        try {
            vkCore.getVk().messages().send(vkCore.getActor()).peerId(peerId).attachment("photo", photoId).execute();
        } catch (ApiException | ClientException e) {
            e.printStackTrace();
        }
    }

    public void sendKeyBoard(String msg, int peerId, ArrayList<String> buttonTexts){
        StringBuilder keyboard = new StringBuilder("{\n" +
                "  \"one_time\": true,\n" +
                "  \"buttons\": [\n" +
                "    [\n");
        var i = 1;
        for (String text : buttonTexts){
            keyboard.append("      {\n" + "        \"action\": {\n" + "          \"type\": \"text\",\n" + "          \"payload\": \"{\\\"button\\\": \\\"").append(i).append("\\\"}\",\n").append("          \"label\": \"").append(text).append("\"\n").append("        },\n").append("        \"color\": \"primary\"\n");
            if (i == buttonTexts.size())
                    keyboard.append("      }\n");
            else keyboard.append("      },\n");
            i++;
        }


         keyboard.append("    ]\n" + "  ]\n" + "} ");
        try {
            vkCore.getVk().messages().send(vkCore.getActor()).peerId(peerId).message(msg).unsafeParam("keyboard", keyboard.toString()).execute();

        } catch (ApiException | ClientException e) {
            e.printStackTrace();
        }
    }

    public void sendKeyboardWithTwoButtons(String msg, String buttonOneText, String buttonTwoText, int peerId){
        JsonObject userJson = new JsonObject();
        userJson.addProperty("one_time", true);

        String keyboard = "{\n" +
                "  \"one_time\": true,\n" +
                "  \"buttons\": [\n" +
                "    [\n" +

                "      {\n" +
                "        \"action\": {\n" +
                "          \"type\": \"text\",\n" +
                "          \"payload\": \"{\\\"button\\\": \\\"1\\\"}\",\n" +
                "          \"label\": \""+buttonOneText+"\"\n" +
                "        },\n" +
                "        \"color\": \"positive\"\n" +
                "      },\n" +

                "      {\n" +
                "        \"action\": {\n" +
                "          \"type\": \"text\",\n" +
                "          \"payload\": \"{\\\"button\\\": \\\"2\\\"}\",\n" +
                "          \"label\": \""+buttonTwoText+"\"\n" +
                "        },\n" +
                "        \"color\": \"negative\"\n" +
                "      }\n" +

                "    ]\n" +
                "  ]\n" +
                "} ";

        try {
            vkCore.getVk().messages().send(vkCore.getActor()).peerId(peerId).message(msg).unsafeParam("keyboard", keyboard).execute();

        } catch (ApiException | ClientException e) {
            e.printStackTrace();
        }
    }

    public void sendSticker(int peerId){
        try {
            vkCore.getVk().messages().send(vkCore.getActor()).peerId(peerId).stickerId(141).execute();
        } catch (ApiException | ClientException e) {
            e.printStackTrace();
        }

    }

    public MessagesSendQuery getSendQuery(){
        return vkCore.getVk().messages().send(vkCore.getActor());
    }

    public static UserXtrCounters getUserInfo(int id){
        try {
            return vkCore.getVk().users()
                    .get(vkCore.getActor())
                    .userIds(String.valueOf(id))
                    .execute()
                    .get(0);
        } catch (ApiException | ClientException e) {
            e.printStackTrace();
        }
        return null;
    }
}
