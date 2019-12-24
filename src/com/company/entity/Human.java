package com.company.entity;

import com.company.item.Container;
import com.company.item.Item;
import com.company.item.Pickable;
import com.company.item.Valuable;

public class Human extends Creature {
    private boolean isMale;
    private int itemCapacity;
    private Pickable[] items;

    private int index;

    public Human(String name, boolean isMale, int itemCapacity, Room room) {
        super(0, room, name);

        this.isMale = isMale;
        this.itemCapacity = itemCapacity;

        this.items = new Pickable[itemCapacity];
        this.index = 0;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public int getItemCapacity() {
        return itemCapacity;
    }

    public void setItemCapacity(int itemCapacity) {
        this.itemCapacity = itemCapacity;
    }

    public Pickable[] getItems() {
        return items;
    }

    public void whistle(){
        System.out.println(getName() + ": *свистит*");
    }

    public void pick(Pickable item){
        if (index == itemCapacity - 1) {
            drop();
            return;
        }

        items[index++] = item;
        System.out.println(getName() + ": *подобрал " + item.toString() + "*");
        if (item instanceof Valuable) whistle();
    }

    public void rattle(){
        System.out.println(getName() + ": *хрюкнул от страха*");
    }

    public Pickable[] drop(){
        Pickable[] itemsOld = items;
        System.out.println(getName() + " выронил все свои предметы!");

        index = 0;
        items = new Pickable[itemCapacity];

        return itemsOld;
    }

    public void pickAll(Item[] items){
        for (Item item : items) {
            if (item instanceof Container) {
                Container c = (Container) item;
                pickAll(c.getItems());
            }

            if (item instanceof Pickable) pick( (Pickable) item );
        }
    }

    @Override
    public void move(Room room) {
        setRoom(room);
        System.out.println(getName() + ": *переходит в " + room.toString());
    }
}
