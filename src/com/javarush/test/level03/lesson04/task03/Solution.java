package com.javarush.test.level03.lesson04.task03;

/* StarCraft
Создать 10 зергов, 5 протосов и 12 терран.
Дать им всем уникальные имена.
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Zerg zerg1=new Zerg();
        zerg1.name="Zerling";
        Zerg zerg2=new Zerg();
        zerg2.name="Hidralisk";
        Zerg zerg3 = new Zerg();
        zerg3.name="Mutalisk";
        Zerg zerg4=new Zerg();
        zerg4.name="Ultralisk";
        Zerg zerg5=new Zerg();
        zerg5.name="Beiling";
        Zerg zerg6=new Zerg();
        zerg6.name="Infected Cerrigan";
        Zerg zerg7=new Zerg();
        zerg7.name="Zombie";
        Zerg zerg8=new Zerg();
        zerg8.name="Kuku";
        Zerg zerg9=new Zerg();
        zerg9.name="Pupi";
        Zerg zerg10=new Zerg();
        zerg10.name="Kluk";

        Protos Protos1=new Protos();
        Protos1.name="Zealot";
        Protos Protos2=new Protos();
        Protos1.name="Dragoon";
        Protos Protos3=new Protos();
        Protos1.name="Baton";
        Protos Protos4=new Protos();
        Protos1.name="Corsar";
        Protos Protos5=new Protos();
        Protos1.name="Protos cerry";

        Terran Terran1=new Terran();
        Terran1.name="Petya";
        Terran Terran2=new Terran();
        Terran1.name="Vasya";
        Terran Terran3=new Terran();
        Terran1.name="Koya";
        Terran Terran4=new Terran();
        Terran1.name="Ivan";
        Terran Terran5=new Terran();
        Terran1.name="Andrew";
        Terran Terran6=new Terran();
        Terran1.name="Roman";
        Terran Terran7=new Terran();
        Terran1.name="Vitaliy";
        Terran Terran8=new Terran();
        Terran1.name="Cerrygan";
        Terran Terran9=new Terran();
        Terran1.name="Reynor";
        Terran Terran10=new Terran();
        Terran1.name="BattleCruser";
        Terran Terran11=new Terran();
        Terran1.name="Medic";
        Terran Terran12=new Terran();
        Terran1.name="Tayler";

    }

    public static class Zerg
    {
        public String name;
    }

    public static class Protos
    {
        public String name;
    }

    public static class Terran
    {
        public String name;
    }
}