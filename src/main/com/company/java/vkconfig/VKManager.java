package main.com.company.java.vkconfig;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.users.UserXtrCounters;
import com.vk.api.sdk.queries.messages.MessagesSendQuery;

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

    public void sendKeyBoardWithThreeButtons(String msg, String buttonOneText, String buttonTwoText, String buttonThreeText, int peerId){
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
                "        \"color\": \"primary\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"action\": {\n" +
                "          \"type\": \"text\",\n" +
                "          \"payload\": \"{\\\"button\\\": \\\"2\\\"}\",\n" +
                "          \"label\": \""+buttonTwoText+"\"\n" +
                "        },\n" +
                "        \"color\": \"primary\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"action\": {\n" +
                "          \"type\": \"text\",\n" +
                "          \"payload\": \"{\\\"button\\\": \\\"3\\\"}\",\n" +
                "          \"label\": \""+buttonThreeText+"\"\n" +
                "        },\n" +
                "        \"color\": \"primary\"\n" +
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

    public void sendKeyboardWithTwoButtons(String msg, String buttonOneText, String buttonTwoText, int peerId){
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
