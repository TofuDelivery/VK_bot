package main.com.company.java.Core;

import com.vk.api.sdk.objects.messages.Message;
import main.com.company.java.Combat;
<<<<<<< HEAD
=======
import main.com.company.java.vkconfig.VKCore;
>>>>>>> 87e53eec934c752727b8011bc085372fb5125dcd
import main.com.company.java.vkconfig.VKManager;
import main.com.company.java.vkconfig.VKServer;

public class MakeTurn extends Command {
    @Override
    public void exec(Game game, Message message) throws InterruptedException {
<<<<<<< HEAD
        var choice = Integer.parseInt(message.getBody());
        if (choice < 1 || choice > game.enemies.enemies.length || game.enemies.enemies[choice - 1].isDead())
            new VKManager().sendMessage("Неккоректный выбор цели, попробуйте еще раз", message.getUserId());
        else {
=======
        if (message.getBody().equals("Убегать")) {
            new VKManager().sendMessage("Вы трусливо убежали от врага", message.getUserId());
            Combat.chooseCurrentEnemy(game, message);
        } else {
>>>>>>> 87e53eec934c752727b8011bc085372fb5125dcd
            var player = game.player;
            var enemies = game.enemies.enemies;
            var currentEnemy = enemies[choice - 1];
            player.attack(currentEnemy, message);
            if (currentEnemy.isDead())
                new VKManager().sendMessage(currentEnemy.name + " падает замертво!", message.getUserId());
            if (Combat.isPartyDead(enemies))
            {
                new VKManager().sendMessage("Вы победили! Ваше текущее здоровье: " + player.currentHealth   , message.getUserId());
                Combat.restoreParty(enemies);
                game.setState(5);
                new VKManager().sendKeyboardWithTwoButtons("Хотите продолжать приключение?","Да", "Нет", message.getUserId());
            }
            else {
                for(var enemy : enemies)
                {
                    if (enemy.isAlive() && player.isAlive())
                        enemy.attack(player, message);
                }
                if (player.isDead()) {
                    new Exit().exec(game, message);
                    Combat.restoreParty(enemies);
                } else {
                    new VKManager().sendKeyboardWithTwoButtons("Что будете делать?","Атаковать", "Убегать", message.getUserId());
                    game.setState(3);
                }
            }
        }
    }
}
