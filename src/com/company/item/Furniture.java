package com.company.item;

public class Furniture extends Item implements Container {
    private int capacity;
    private Item[] items;
    private String name;

    private int index;

    public Furniture(int capacity, String name) {
        this.capacity = capacity;
        this.name = name;

        this.items = new Item[capacity];
        this.index = 0;
    }

    @Override
    public int hashCode() {return index^(name.hashCode()&capacity);}

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Furniture))
            return false;

        return hashCode() == obj.hashCode();
    }

    public String getUsage(){
        return "Открывается " + name;
    }

    public void put(Item item){
        if (index == capacity - 1) {
            System.out.println("Объект мебели " + name + " переполнен.");
            return;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
