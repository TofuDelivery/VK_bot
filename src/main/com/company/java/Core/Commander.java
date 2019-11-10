package main.com.company.java.Core;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Message;

public class Commander {
    private static int state = 0;
    public static void execute(Message message) throws NullPointerException
    {

        var command = CommandDeterminant.getCommand(CommandManager.getCommands(), message, state);
        if (command.name.equals("start")){
            state = 1;
        }
        if (command.name.equals("choice")){
            state = 2;
        }
        command.exec(message);
    }
}
