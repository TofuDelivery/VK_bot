package com.company.commands.State3;

import com.company.commands.Command;
import com.company.commands.Game;
import com.company.vkconfig.VKManager;
import com.vk.api.sdk.objects.messages.Message;

import java.util.ArrayList;

public class ChooseAbility implements Command
{
    @Override
    public void exec(Game game, Message message) throws NullPointerException, InterruptedException
    {
        var abilities = new ArrayList<String>();
        var flag = false;
        for(var ability : game.player.abilitiesList.abilitiesList)
        {
            if(game.player.currentEnergy >= ability.ShowCost())
            {
                abilities.add(ability.ShowName() + "(" + ability.ShowCost() + ")");
                flag = true;
            }
        }
        if(flag)
        {
            new VKManager().sendKeyBoard("Выберите умение", message.getPeerId(), abilities);
            game.setState(3, 5);
        }
        else
            new VKManager().sendMessage("Вы не можете использовать какие-либо умения сейчас", message.getPeerId());
    }
}
