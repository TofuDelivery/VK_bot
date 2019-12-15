package main.com.company.java.Core;

import com.vk.api.sdk.objects.messages.Message;
import main.com.company.java.Combat;
import main.com.company.java.Character;
import main.com.company.java.vkconfig.VKCore;
import main.com.company.java.vkconfig.VKCore;
import main.com.company.java.vkconfig.VKManager;
import main.com.company.java.vkconfig.VKServer;
import org.apache.tools.ant.types.resources.selectors.None;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MakeTurn extends Command {
    @Override
    public void exec(Game game, Message message) throws InterruptedException {
        var choice = Integer.parseInt(message.getBody().split(" ")[1].split(" % ")[0]);
        var player = game.player;
        var enemies = game.enemies.enemies;
        var currentEnemy = new Character("", 0, 0, 0 ,0, 0, 0, 0, 0, 0);
        for (var enemy : enemies){
            if (enemy.currentHealth == choice)
                currentEnemy = enemy;
        }
        player.attack(currentEnemy, message);
        if (currentEnemy.isDead())
            new VKManager().sendMessage(currentEnemy.name + " падает замертво!", message.getUserId());
        if (Combat.isPartyDead(enemies)) {
            new VKManager().sendMessage("Вы победили! Ваше текущее здоровье: " + player.currentHealth, message.getUserId());
            Combat.restoreParty(enemies);
            game.setState(5);
            new VKManager().sendKeyboardWithTwoButtons("Хотите продолжать приключение?", "Да", "Нет", message.getUserId());
        } else {
            for (var enemy : enemies) {
                if (enemy.isAlive() && player.isAlive())
                    enemy.attack(player, message);
            }
            if (player.isDead()) {
                new Exit().exec(game, message);
                Combat.restoreParty(enemies);
            } else {
                new VKManager().sendKeyboardWithTwoButtons("Что будете делать?", "Атаковать", "Убегать", message.getUserId());
                game.setState(3);
            }
        }
    }
}
