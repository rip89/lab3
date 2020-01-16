package com.company.item;

import com.company.CapacityLimitException;

public class Furniture extends Item implements Container {
    private int capacity;
    private Item[] items;

    private int index;

    public Furniture(int capacity, String name) {
        super(name);

        this.capacity = capacity;
        this.items = new Item[capacity];
        this.index = 0;
    }

    public void state(int level) {
        if (level < 10) {
            System.out.println("новый " + getName());
            return;
        }
        if (level < 20) {
            System.out.println("старинный " + getName());
            return;
        }

        System.out.println("древний " + getName());
    }

    @Override
    public int hashCode() {return index^(getName().hashCode()&capacity);}

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Furniture))
            return false;

        return hashCode() == obj.hashCode();
    }

    public void put(Item item){
        if (index == capacity) {
            throw new CapacityLimitException("Объект мебели " + getName() + " переполнен.");
        }

        items[index++] = item;
    }

    @Override
    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
