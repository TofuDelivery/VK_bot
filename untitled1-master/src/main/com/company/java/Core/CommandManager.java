package main.com.company.java.Core;

import java.util.HashSet;

public class CommandManager{

    private static HashSet<Command> commands = new HashSet<>();

    static {
        commands.add(new Hello("hello"));
        commands.add(new Unknown("unknown"));
    }

    public static HashSet<Command> getCommands(){
        return commands;
    }
    public static void addCommand(Command command) { commands.add(command);}
}
