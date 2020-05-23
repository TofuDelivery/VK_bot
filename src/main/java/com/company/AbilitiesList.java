package com.company;

import com.company.vkconfig.VKManager;
import com.vk.api.sdk.objects.messages.Message;

import java.util.ArrayList;

public class AbilitiesList
{
    public Character owner;
    public ArrayList<Ability> abilitiesList;

    public AbilitiesList(Character owner)
    {
        this.owner = owner;
        this.abilitiesList = new ArrayList<Ability>();
    }

    public void ShowAbilities(Message message)
    {
        var text = "";
        for(Ability ability : abilitiesList)
            text += ability.ShowName() + "\n";
        new VKManager().sendMessage(text, message.getPeerId());
    }

    public void AddAbility(Ability ability)
    {
        abilitiesList.add(ability);
    }
}