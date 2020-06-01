package com.company;

import com.company.Abilities.AssassinA.FanOfKnifes;
import com.company.Abilities.CasterA.Iceshard;
import com.company.Abilities.SaberA.DoubleSlash;

import java.util.HashMap;

public class Classes {
    public static HashMap<String, Character> characters = new HashMap<String, Character>()
    {{
        put("Мечник", new Character("Мечник", 0,1, 100, 10,15, 10, 5, 10, 0, 0, new DoubleSlash()));
        put("Ассассин", new Character("Ассассин",0, 1, 80, 20,20, 12, 20, 0, 5, 0, new FanOfKnifes()));
        put("Заклинатель", new Character("Заклинатель",0, 1, 60, 30,30, 8, 10, 0, 0, 0, new Iceshard()));
    }};
}