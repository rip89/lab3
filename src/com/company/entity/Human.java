package com.company.entity;

public class Human extends Creature {

    private boolean isMale;
    private int index;

    public Human(String name, boolean isMale, Location location) {
        super(0, location, name);

        this.isMale = isMale;

        this.index = 0;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public void whistle(){
        System.out.println(getName() + ": *свистит*");
    }

    @Override
    public int hashCode() {
        return index ^ ( getName().hashCode() );
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Human))
            return false;

        return hashCode() == obj.hashCode();
    }

    public void rattle(){
        System.out.println(getName() + ": *хрюкнул от страха*");
    }

    @Override
    public void move(Location location, int loudness) {
        setLocation(location);
        if (loudness < 2) {
            System.out.println(getName() + ": *на цыпочках пробирается в " + location.toString()+"*");
            return;
        }
        if (loudness < 5) {
            System.out.println(getName() + ": *крадется в " + location.toString()+"*");
            return;
        }
        if (loudness < 10) {
            System.out.println(getName() + ": *переходит в " + location.toString()+"*");
            return;
        }
        if (loudness < 15) {
            System.out.println(getName() + ": *шоркает в  " + location.toString()+"*");
            return;
        }

        System.out.println(getName() + ": *топает в " + location.toString()+"*");
    }
}