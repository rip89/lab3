package com.company.entity;

public class Ghost extends Creature implements Scary {
    public Ghost(Location location, String name) {
        super(0, location, name);
    }

    @Override
    public void groan(int level) {
        if (level < 10) {
            System.out.println("Привидение " + getName() + ": *тихонько стонет*");
            return;
        }
        if (level < 20) {
            System.out.println("Привидение " + getName() + ": *стонет*");
            return;
        }
        if (level < 30) {
            System.out.println("Привидение " + getName() + ": *кричит*");
            return;
        }

        System.out.println("Привидение " + getName() + ": *ОРЕТ И РЫЧИТ*");
    }

    @Override
    public int hashCode() {
        return ( getName().hashCode() );
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Ghost))
            return false;

        return hashCode() == obj.hashCode();
    }

    @Override
    public void flutter(Creature creature) {
        System.out.println("Привидение " + getName() + ": *кружит вокруг " + creature.getName() + "*");
        creature.setFear( creature.getFear() + 10 );
    }

    public void scare(Human target, Reaction reaction){
        System.out.printf("%s напугал %s!\n", this.getName(), target.getName());
        reaction.apply(target);
    }

    @Override
    public void sigh() {
        System.out.println("Привидение " + getName() + ": *вздыхает*");
    }

    @Override
    public void move(Location location, int loudness) {
        setLocation(location);
        System.out.println("Привидение " + getName() + ": *перелетает в " + location.toString() + "*");
    }
}

