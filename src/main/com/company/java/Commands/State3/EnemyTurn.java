package main.com.company.java.Commands.State3;

import com.vk.api.sdk.objects.messages.Message;
import main.com.company.java.Combat;
import main.com.company.java.Commands.Command;
import main.com.company.java.Commands.Exit;
import main.com.company.java.Commands.Game;
import main.com.company.java.vkconfig.VKManager;

import java.util.ArrayList;

public class EnemyTurn implements Command {
    public void exec(Game game, Message message) throws NullPointerException, InterruptedException
    {
        var player = game.player;
        var enemies = game.enemies.enemies;
        for (var enemy : enemies) {
            if (enemy.isAlive() && player.isAlive())
                enemy.attack(player, message);
        }
        if (player.isDead()) {
            new Exit().exec(game, message);
            Combat.restoreParty(enemies);}
        else
            {
                ArrayList<String> buttonTexts = new ArrayList<>();
                buttonTexts.add("Атаковать");
                buttonTexts.add("Пить зелье");
                buttonTexts.add("Убегать");
                new VKManager().sendKeyBoard("Что будете делать?", message.getUserId(), buttonTexts);
                game.setState(3, 0);
            }
    }
}
