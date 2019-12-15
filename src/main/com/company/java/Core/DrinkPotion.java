package main.com.company.java.Core;

import com.vk.api.sdk.objects.messages.Message;
import main.com.company.java.Combat;
import main.com.company.java.vkconfig.VKManager;

public class DrinkPotion extends Command{
    @Override
    public void exec(Game game, Message message) throws NullPointerException, InterruptedException
    {
        var choice = Integer.parseInt(message.getBody());
        if (choice < 1 || choice > game.player.potions.count)
            new VKManager().sendMessage("Неккоректный выбор зелья, попробуйте еще раз", message.getUserId());
        else
        {
            var player = game.player;
            var enemies = game.enemies.enemies;
            var currentHealth = player.currentHealth;
            var currentPotion = game.player.potions.potions[choice - 1].name;
            game.player.potions.consume(choice - 1);
            var healedHealth = player.currentHealth - currentHealth;
            new VKManager().sendMessage("Вы использовали " + currentPotion + " и восстановили " + healedHealth + "очков здоровья!", message.getUserId());
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