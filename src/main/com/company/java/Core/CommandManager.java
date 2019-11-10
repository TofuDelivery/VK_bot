package main.com.company.java.Core;

import java.util.HashMap;


class CommandManager{

    private static HashMap<Integer, HashMap<String, Command>> commands = new HashMap<>();
    private static CommandsPools commandsPools = new CommandsPools();
    static{
        commands.put(0, commandsPools.getStateZeroCommands());
        commands.put(1, commandsPools.getStateOneCommands());
        commands.put(2, commandsPools.getStateTwoCommands());
    }

    static HashMap<Integer, HashMap<String, Command>> getCommands(){
        return commands;
    }
}
