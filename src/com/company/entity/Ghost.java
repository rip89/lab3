package com.company.entity;

public class Ghost extends Creature implements Scary {
    private int transparency;
    private int height;

    public Ghost(Room location, String name) {
        super(0, location, name);
    }

    public int getTransparency(){return transparency;}

    public void setTransparency(int transparency) {
        this.transparency = transparency;
    }

    public int getHeight(){return height;}

    public void setHeight(int height) {
        this.transparency = transparency;
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

        System.out.println("Привидение " + getName() + ": *ОРЕТ И РЫЧИТ*");
    }

    @Override
    public int hashCode() {return height^(getName().hashCode() & transparency);}

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

    @Override
    public void sigh() {
        System.out.println("Привидение " + getName() + ": *вздыхает*");
    }

    @Override
    public void move(Room room) {
        setRoom(room);
        System.out.println("Привидение " + getName() + ": *перелетает в " + room.toString() + "*");
    }
}

