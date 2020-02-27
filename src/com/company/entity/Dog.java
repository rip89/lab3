package com.company.entity;

public class Dog extends Creature {
    private boolean isMale;

    public Dog(String name, boolean isMale, Location location) {
        super(0, location, name);
        this.isMale = isMale;
    }

    @Override
    public void move(Location location, int loudness) {
        setLocation(location);
        System.out.println(getName() + ": *переходит в " + location.toString() + "*");
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }
}
