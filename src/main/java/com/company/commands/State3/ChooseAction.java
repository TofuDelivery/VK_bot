package com.company.commands.State3;

import com.company.commands.Command;
import com.company.commands.Game;
import com.company.vkconfig.VKManager;
import com.vk.api.sdk.objects.messages.Message;

public class ChooseAction implements Command {
    @Override
    public void exec(Game game, Message message) throws NullPointerException, InterruptedException
    {
        var action = message.getText().toLowerCase();
        if(action.equals("атаковать"))
            new ChooseTargetForAttack().exec(game, message);
        else if (action.equals("пить зелье"))
            new SelectPotion().exec(game, message);
        else if(action.equals("убегать"))
            new Escape().exec(game, message);
        else if(action.equals("использовать умение"))
            new ChooseAbility().exec(game, message);
        else if(action.equals("статус"))
            new ShowPlayerStatus().exec(game, message);
        else
            new VKManager().sendMessage("Неправильная команда, попробуйте еще раз", message.getPeerId());
    }
}
