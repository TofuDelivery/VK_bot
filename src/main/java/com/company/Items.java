package com.company;

import java.util.HashMap;

public class Items {
    public static HashMap<String, Item> items = new HashMap<String, Item>()
    {{
        put("Медальон здоровья", new Item("heal", new Bonus(10, 0, 0, 0, 0, 0)));
        put("Медальон силы", new Item("force", new Bonus(0, 10, 5, 0, 0, 0)));

    }};
}
