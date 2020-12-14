package com.company.Droids;

import java.lang.reflect.Constructor;

public class DroidHub {
    final private static String[] DroidTypeNames = {
        "Ranger",
        "Tank",
        "Support",
    };

    final private static String[] DroidTypeAbility = {
        "Critical damage",
        "Damage absorption",
        "Repair",
    };

    final private static Integer[] DroidTypeHealth = {
        70, 120, 40,
    };

    final private static Integer[] DroidTypeDamage = {
        30, 17, 10,
    };

    public static String getDroidType(Droid a) {
        return a.getClass().getSimpleName();
    }

    public static Boolean isDroidType(String type) {
        return getTypeId(type) >= 0;
    }

    private static Integer getTypeId(String type) {
        for(int i = 0; i < DroidTypeNames.length; ++i) {
            if(DroidTypeNames[i].equalsIgnoreCase(type)){
                return i;
            }
        }
        return -1;
    }

    public static Integer getDroidHealth(String type) {
        return isDroidType(type) ? DroidTypeHealth[getTypeId(type)] : -1;
    }

    public static Integer getDroidHealth(Droid a) {
        return getDroidHealth(getDroidType(a));
    }

    public static Integer getDroidDamage(String type) {
        return isDroidType(type) ? DroidTypeDamage[getTypeId(type)] : -1;
    }

    public static Integer getDroidDamage(Droid a) {
        return getDroidDamage(getDroidType(a));
    }

    public static String getDroidAbility(String type) {
        return isDroidType(type) ? DroidTypeAbility[getTypeId(type)] : "";
    }

    public static String getDroidAbility(Droid a) {
        return getDroidAbility(getDroidType(a));
    }

    public static String getDroidInfo(String type) {
        if(isDroidType(type)) {
            return  "> Health: "  + getDroidHealth(type).toString() + "\n" +
                    "> Damage: "  + getDroidDamage(type).toString() + "\n" +
                    "> Ability: " + getDroidAbility(type);
        }
        return "";
    }

    public static Droid createDroid(String type, String name) {
        if(isDroidType(type)) {
            try {
                var id = getTypeId(type);
                Class<?> BrandNewDroidClass = Class.forName("com.company.Droids." + DroidTypeNames[id]);
                Constructor<?> DroidConstructor = BrandNewDroidClass.getConstructor(String.class);
                Droid BrandNewDroid = ((Droid) DroidConstructor.newInstance(new Object[]{name}));
                return BrandNewDroid;
            } catch (Exception e) {
                System.out.println("Can't create" + type + " droid");
            }
        }
        return null;
    }
}