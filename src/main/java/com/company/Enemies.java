package com.company;

public class Enemies
{
     private static EnemiesParty[] enemies = {
             new EnemiesParty("Ёжик", new Character("Ёжик", 0,1, 10, 1, 0, 0, 0, 0, 10)),
             new EnemiesParty("Крыса", new Character("Крыса", 0,  1, 6, 4, 1, 10, 0, 10, 40)),
             new EnemiesParty("Волк", new Character("Волк", 0, 1, 20, 6, 4, 5, 0, 0, 100)),
             new EnemiesParty("Кабан", new Character("Кабан",0, 1, 30, 6, 1, 0, 10, 0, 150)),
             new EnemiesParty("Гоблин", new Character("Гоблин",0, 1, 15, 8, 3, 10, 0, 0, 150)),
             new EnemiesParty("Кобольд", new Character("Кобольд", 0, 1, 25, 8, 5, 5, 0, 5, 200)),
             new EnemiesParty("Отряд Ёжиков", new Character("Ёжик",0, 1, 10, 1, 0, 0, 0, 0, 10), new Character("Ёжик",1,1, 10, 1, 0, 0, 0, 0, 10), new Character("Ёжик", 2, 1, 10, 1, 0, 0, 0, 0, 10), new Character("Ёжик", 3, 1, 10, 1, 0, 0, 0, 0, 10), new Character("Ёжик", 4, 1, 10, 1, 0, 0, 0, 0, 10)),
             new EnemiesParty("Два Кобольда", new Character("Кобольд",0, 1, 25, 8, 5, 5, 0, 5, 200), new Character("Кобольд",1, 1, 25, 8, 5, 5, 0, 5, 200)),
             new EnemiesParty("Крысиная свора", new Character("Крыса", 0,1, 6, 4, 1, 10, 0, 10, 40), new Character("Крыса", 1, 1, 6, 4, 1, 10, 0, 10, 40), new Character("Крыса", 2, 1, 6, 4, 1, 10, 0, 10, 40), new Character("Крыса", 3, 1, 6, 4, 1, 10, 0, 10, 40)),
             new EnemiesParty("Стая волков", new Character("Волк",0, 1, 20, 6, 4, 5, 0, 0, 100), new Character("Волк", 1, 1, 20, 6, 4, 5, 0, 0, 100), new Character("Волк", 2, 1, 20, 6, 4, 5, 0, 0, 100)),
             new EnemiesParty("Хобгоблин", new Character("Хобгоблин", 0, 1, 30, 16, 4, 15, 0, 0, 300)),
             new EnemiesParty("Орк", new Character("Орк",0, 1, 50, 20, 10, 10, 5, 5, 500)),
             new EnemiesParty("Отряд зеленокожих", new Character("Гоблин", 0,1, 15, 8, 3, 10, 0, 0, 150), new Character("Гоблин", 1,1, 15, 8, 3, 10, 0, 0, 150), new Character("Орк", 0,1, 50, 20, 10, 10, 5, 5, 500))
     };

     public static EnemiesParty ChooseEnemy(int number)
     {
          return enemies[number];
     }

     public static int getCount()
     {
          return enemies.length;
     }
}