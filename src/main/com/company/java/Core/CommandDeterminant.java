package main.com.company.java.Core;

import com.vk.api.sdk.objects.messages.Message;
import java.util.HashMap;

class CommandDeterminant {
    static Command getCommand(HashMap<Integer, HashMap<String, Command>> commands, Message message, int state) {
        String body = message.getBody();
        try{
            var command = commands.get(state).get(body);
            if (command != null){
                return command;
            }else{
                throw new NullPointerException();
            }

        }catch (NullPointerException e){
            return new Unknown(state, "unknown");
        }
    }
}
