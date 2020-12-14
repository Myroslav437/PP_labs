package com.company.Droids;

public class Support extends  Droid {
    private boolean makeAttack = true;
    final private static int HealthSupport = 20;

    public Support(String name) {
        super(name, DroidHub.getDroidHealth("Support"), DroidHub.getDroidDamage("Support"));
    }

    @Override
    public boolean fullHealth() {
        return getHealth() >= DroidHub.getDroidHealth("Support");
    }

    @Override
    protected int sendDamage() {
        if(makeAttack) {
            return super.sendDamage();
        }
        else {
            makeAttack = true;
            return 0;
        }
    }

    @Override
    public int sendSupport(Droid a) {
        if(a.fullHealth()) {
            makeAttack = true;
            return 0;
        }
        else {
            makeAttack = false;
            return makeSupport(a);
        }
    }

    protected int makeSupport(Droid a) {
        int diff = DroidHub.getDroidHealth(a) - a.getHealth();
        int help = Math.min(diff, HealthSupport);
        a.setHealth(a.getHealth() + help);

        return help;
    }

}
