
package main.com.company.java;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.objects.messages.Message;
import main.com.company.java.vkconfig.VKManager;

import java.util.Random;

public class Adventure
{
    private static NewCharacter player;

    public Adventure(NewCharacter player){
        Adventure.player = player;
    }

    public static void Run(Message msg) throws NullPointerException, ApiException, ClientException, InterruptedException
    {
        var random = new Random();
        while(player.isAlive())
        {
            var enemy = Enemies.ChooseEnemy(random.nextInt(22));
            new VKManager().sendMessage("Your enemy is " +  enemy.name + "!" , msg.getUserId());
            Thread.sleep(1000);
            Combat.fight(player, enemy, msg);
        }
    }
}
