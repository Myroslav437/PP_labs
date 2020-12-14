package com.company.Droids;

import java.util.Random;

public abstract class Droid {
    private String Name;
    private int Health;
    private int Damage;

    public Droid(String name, int health, int damage) {
        Name = name;
        Health = health;
        Damage = damage;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getHealth() {
        return Health;
    }

    protected void setHealth(int health) {
        Health = health;
    }

    public int getDamage() {
        return Damage;
    }

    protected void setDamage(int damage) {
        Damage = damage;
    }

    public boolean isAlive() {
        return getHealth() > 0;
    }

    protected int sendDamage() {
        double damage = getDamage();
        final Random rand = new Random();
        damage += rand.nextGaussian() * 3.0;

        return (int)damage;
    }

    public int receiveDamage(final Droid a) {
        var res = a.sendDamage();
        this.Health -= res;
        return res;
    }

    public abstract boolean fullHealth();

    public abstract int sendSupport(Droid a);
}
