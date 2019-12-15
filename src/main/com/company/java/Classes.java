package main.com.company.java;

import java.util.HashMap;

public class Classes {
    public static HashMap<String, Character> characters = new HashMap<String, Character>()
    {{
        put("Мечник", new Character("Мечник", 0,1, 100, 15, 10, 5, 10, 0, 0));
        put("Ассассин", new Character("Ассассин",0, 1, 80, 20, 12, 20, 0, 5, 0));
        put("Заклинатель", new Character("Заклинатель",0, 1, 60, 30, 8, 10, 0, 0, 0));
    }};
}
