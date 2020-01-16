package com.company.entity;

import com.company.item.Furniture;

public abstract class Creature {
    private int fear;
    private Location location;
    private String name;
    private Furniture hideFurniture;

    public abstract void move(Location location, int loudness);

    public Creature(int fear, Location location, String name) {
        this.fear = fear;
        this.location = location;
        this.name = name;
    }

    public void hide(Furniture furniture) {
        hideFurniture = furniture;
        System.out.println(name + ": *залез в " + hideFurniture.getName() + "*");
    }

    public void unhide() {
        System.out.println(name + ": *вылез из " + hideFurniture.getName() + "*");
        hideFurniture = null;
    }

    public void fear(int level) {
        fear += level;
        if (fear < 1) {
            System.out.println(getName() + ": *не испугался*");
            return;
        }
        if (fear < 10) {
            System.out.println(getName() + ": *испугался*");
            return;
        }
        if (fear < 20) {
            System.out.println(getName() + ": *страшно испугался*");
            return;
        }

        System.out.println(getName() + ":  *получил инфаркт*");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFear() {
        return fear;
    }

    public void setFear(int fear) {
        this.fear = fear;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
