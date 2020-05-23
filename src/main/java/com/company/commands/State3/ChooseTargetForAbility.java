package com.company.commands.State3;

import com.company.commands.Command;
import com.company.commands.Game;
import com.vk.api.sdk.objects.messages.Message;

public class ChooseTargetForAbility implements Command
{
    @Override
    public void exec(Game game, Message message) throws NullPointerException, InterruptedException
    {
        var choice = message.getText().split("\\(")[0];
        for(var ability : game.player.abilitiesList.abilitiesList)
        {
            if (ability.ShowName().equals(choice))
                game.player.currentAbility = ability;
        }
        game.player.currentAbility.ChooseTarget(game, message);
        game.setState(3, 6);
    }
}
