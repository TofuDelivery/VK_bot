package com.company.commands.State3;

import com.vk.api.sdk.objects.messages.Message;
import com.company.Character;
import com.company.Combat;
import com.company.commands.Command;
import com.company.commands.Game;
import com.company.vkconfig.VKManager;

import java.util.ArrayList;

public class Attack implements Command {
    public void exec(Game game, Message message) throws NullPointerException, InterruptedException
    {
        var choice = Integer.parseInt(message.getText().split(" ")[1].split(" % ")[0]);
        var player = game.player;
        var enemies = game.enemies.enemies;
        var currentEnemy = new Character("", 0, 0, 0 ,0, 0, 0, 0, 0, 0);
        for (var enemy : enemies){
            if (enemy.currentHealth == choice)
                currentEnemy = enemy;
        }
        player.attack(currentEnemy, message);
        if (currentEnemy.isDead())
            new VKManager().sendMessage(currentEnemy.name + " падает замертво!", message.getPeerId());
        if (Combat.isPartyDead(enemies)) {
            new VKManager().sendMessage("Вы победили! Ваше текущее здоровье: " + player.currentHealth, message.getPeerId());
            Combat.restoreParty(enemies);
            new VKManager().sendKeyBoard("Куда хотите отправиться?", message.getPeerId(), new ArrayList<>(){{ add("Деревня"); add("Приключение");}});
            game.setState(5, 0);
        }
        else
            new EnemyTurn().exec(game, message);
    }
}
