package com.company;

import com.company.commands.Game;
import com.vk.api.sdk.objects.messages.Message;


public interface Ability
{
    int ShowCost();

    String ShowName();

    void ChooseTarget(Game game, Message message) throws InterruptedException;

    void cast(Character[] targets, Message message);
}
