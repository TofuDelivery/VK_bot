package com.company.commands.State3;

import com.company.Character;
import com.company.Combat;
import com.company.commands.Command;
import com.company.commands.Game;
import com.company.vkconfig.VKManager;
import com.vk.api.sdk.objects.messages.Message;


public class CastAbility implements Command
{
    @Override
    public void exec(Game game, Message message) throws NullPointerException, InterruptedException
    {
        var choice = message.getText();
        Character[] targets = getTargets(game, choice);
        game.player.currentEnergy -= game.player.currentAbility.ShowCost();
        game.player.currentAbility.cast(targets, message);
        var enemies = game.enemies.enemies;
        if (Combat.isPartyDead(enemies)) {
            new VKManager().sendMessage("Вы победили! Ваше текущее здоровье: " + game.player.currentHealth, message.getPeerId());
            Combat.restoreParty(enemies);
            new VKManager().sendKeyboardWithTwoButtons("Хотите продолжать приключение?", "Да", "Нет", message.getPeerId());
            game.setState(3, 4);
        }
        else
            new EnemyTurn().exec(game, message);
    }

    private Character[] getTargets(Game game, String choice)
    {
        var name = choice.split(" ")[0];
        var curHealth = Integer.parseInt(choice.split(" ")[1]);
        for(var enemy : game.enemies.enemies)
            if(enemy.name.equals(name) && enemy.currentHealth == curHealth)
                return new Character[]{ enemy };
            return null;
    }
}
