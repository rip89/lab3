package com.company.entity;

import com.company.item.Furniture;

public abstract class Creature {
    private int fear;
    private Room room;
    private String name;

    public abstract void move(Room room);

    public void use(Furniture furniture){
        System.out.println(furniture.getUsage());
    }

    public Creature(int fear, Room location, String name) {
        this.fear = fear;
        room = location;
        this.name = name;
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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
