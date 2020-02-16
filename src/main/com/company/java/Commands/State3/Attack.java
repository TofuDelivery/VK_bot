package main.com.company.java.Commands.State3;

import com.vk.api.sdk.objects.messages.Message;
import main.com.company.java.Character;
import main.com.company.java.Combat;
import main.com.company.java.Commands.Command;
import main.com.company.java.Commands.Game;
import main.com.company.java.vkconfig.VKManager;

public class Attack extends Command {
    @Override
    public void exec(Game game, Message message) throws NullPointerException, InterruptedException
    {
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
            new VKManager().sendKeyboardWithTwoButtons("Хотите продолжать приключение?", "Да", "Нет", message.getUserId());
            game.setState(3, 4);
        }
        else
            new EnemyTurn().exec(game, message);
    }
}
