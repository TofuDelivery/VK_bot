package main.com.company.java.Core;

import java.util.HashMap;

class CommandsPools {

    private HashMap<String, Command> stateZeroCommands;
    private HashMap<String, Command> stateOneCommands;
    private HashMap<String, Command> stateTwoCommands;

    CommandsPools(){
        this.stateZeroCommands = new HashMap<>(){{
            put("start", new Start(0, "start"));
            put("Привет", new Hello(0, "hello"));
        }};
        this.stateOneCommands = new HashMap<>(){{
            put("1", new Choice(1, "choice"));
            put("2", new Choice(1, "choice"));
            put("3", new Choice(1, "choice"));
        }};
        this.stateTwoCommands = new HashMap<>();
    }

    HashMap<String, Command> getStateZeroCommands(){
        return stateZeroCommands;
    }

    HashMap<String, Command> getStateOneCommands(){
        return stateOneCommands;
    }

    HashMap<String, Command> getStateTwoCommands(){
        return stateTwoCommands;
    }
}
