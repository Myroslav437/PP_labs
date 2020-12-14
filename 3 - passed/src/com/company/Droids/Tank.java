package com.company.Droids;

import java.util.Random;

public class Tank extends  Droid {
    public Tank(String name) {
        super(name, DroidHub.getDroidHealth("Tank"), DroidHub.getDroidDamage("Tank"));
    }

    @Override
    public int receiveDamage(Droid a) {
        // Test your luck on damage absorption:
        int res = 0;
        if((new Random()).nextInt(100) >= 20)  {   // !(20% of probability)
            res = super.receiveDamage(a);
        }

        return res;
    }

    @Override
    public boolean fullHealth() {
        return getHealth() >= DroidHub.getDroidHealth("Tank");
    }

    @Override
    public int sendSupport(Droid a) {
        return 0;
    }
}
