package com.company.commands;

import com.vk.api.sdk.objects.messages.Message;

public  interface Command {

     void exec(Game game, Message message) throws NullPointerException, InterruptedException;

}
