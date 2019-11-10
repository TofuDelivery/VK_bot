package main.com.company.java;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import main.com.company.java.vkconfig.VKManager;

import static main.com.company.java.vkconfig.VKServer.vkCore;

public class Classes {
    private NewCharacter[] characters =  {
            new NewCharacter("Saber", 1, 100, 15, 10, 5, 10, 0, 0),
            new NewCharacter("Assassin", 1, 80, 20, 12, 20, 0, 5, 0),
            new NewCharacter("Caster", 1, 60, 30, 8, 10, 0, 0, 0)
    };

    public NewCharacter[] getCharacters() {
        return characters;
    }

    void ChooseClass(NewCharacter player, int userId){
        new VKManager().sendMessage("Choose your class - 1)Saber  2)Assassin 3)Caster", userId);
        try{
            var msg = vkCore.getMessage();
            var choice = Integer.parseInt(msg.toString());

            if (choice <= characters.length && choice >= 0)
                player.changeCharacter(characters[choice - 1]);
            else{
                new VKManager().sendMessage("Incorrect input, try again", userId);

                System.exit(1);
            }

        }catch (ClientException | ApiException  e) {
            e.printStackTrace();
        }
    }
}
