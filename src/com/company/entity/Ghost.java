package com.company.entity;

public class Ghost extends Creature implements Scary {

    public Ghost(Room location, String name) {
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

        System.out.println("Привидение " + getName() + ": *оРЕТ И РЫЧИТ*");
    }

    @Override
    public void flutter(Creature creature) {
        System.out.println("Привидение " + getName() + ": *кружит вокруг " + creature.getName());
        creature.setFear( creature.getFear() + 10 );
    }

    @Override
    public void sigh() {
        System.out.println("Привидение " + getName() + ": *вздыхает*");
    }

    @Override
    public void move(Room room) {
        setRoom(room);
        System.out.println("Привидение " + getName() + ": *перелетает в " + room.toString());
    }
}

