package main.com.company.java.Core;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Message;
import main.com.company.java.Adventure;
import main.com.company.java.Classes;
import main.com.company.java.NewCharacter;
import main.com.company.java.vkconfig.VKManager;

public class Choice extends Command {

    private NewCharacter player;
    private NewCharacter[] characters;

    public Choice(int state, String name) {
        super(state, name);
        this.player = new NewCharacter(null, 0, 0, 0, 0,0,0,0,0);
        var classes = new Classes();
        this.characters = classes.getCharacters();
    }

    public NewCharacter getPlayer(){
        return player;
    }

    @Override
    public void exec(Message message) throws NullPointerException, ApiException, ClientException, InterruptedException
    {
        getChoice(message);
        startAdventure(message);
    }

    private void  getChoice(Message message){
        var choice = Integer.parseInt(String.valueOf(message.getBody()));
        if (choice <= characters.length && choice >= 0)
            player.changeCharacter(characters[choice - 1]);
        else{
            new VKManager().sendMessage("Incorrect input, try again", message.getUserId());
            System.exit(1);
        }
    }

    private void startAdventure(Message message) throws NullPointerException, ApiException, ClientException, InterruptedException
    {
        var adventure = new Adventure(player);
        try {
            adventure.Run(message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
