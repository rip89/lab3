package com.company.entity;

import com.company.CapacityLimitException;
import com.company.item.Container;
import com.company.item.Item;
import com.company.item.Pickable;
import com.company.item.Valuable;

public class Thief extends Human {
    private Bag bag;

    public Thief(String name, boolean isMale, int itemCapacity, Location location) {
        super(name, isMale, location);

        this.bag = new Bag(itemCapacity);
    }

    public void pick(Pickable item){
        try {
            bag.put(item);
        }
        catch (CapacityLimitException exc) {
            System.out.println( exc.getMessage() );
            drop();
            return;
        }
        System.out.println(getName() + ": *подобрал " + item.toString() + "*");
        if (item instanceof Valuable) whistle();
    }

    public void drop(){
        bag.clear();
        System.out.println(getName() + " выронил все свои предметы!");
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

    public void pickAll(Container container) {
        pickAll(container.getItems());
    }


    private static class Bag {
        private int capacity;
        private Pickable[] items;

        private int index;

        private Bag(int capacity) {
            this.capacity = capacity;

            this.items = new Pickable[capacity];
            this.index = 0;
        }

        private void put(Pickable item) {
            if (index == capacity) {
                throw new CapacityLimitException("Не могу поместить предмет в сумку: " + (index + 1) );
            }

            items[index++] = item;
        }

        private Pickable get(int index) {
            return items[index];
        }

        private void clear() {
            items = new Pickable[capacity];
            index = 0;
        }
    }
}
