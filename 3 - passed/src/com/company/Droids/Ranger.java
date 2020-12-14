package com.company.Droids;

import java.util.Random;

public class Ranger extends  Droid {
    public Ranger(String name) {
        super(name, DroidHub.getDroidHealth("Ranger"), DroidHub.getDroidDamage("Ranger"));
    }

    @Override
    public int sendDamage() {
        double damage = super.sendDamage();

        // Test your luck on critical damage)
        final Random rand = new Random();
        if(rand.nextInt(100) < 20)  {   // 20% of probability
            damage *= 1.4;
        }

        return (int)damage;
    }

    @Override
    public boolean fullHealth() {
        return getHealth() >= DroidHub.getDroidHealth("Ranger");
    }

    @Override
    public int sendSupport(Droid a) {
        return 0;
    }
}
