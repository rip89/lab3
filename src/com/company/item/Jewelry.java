package com.company.item;

public class Jewelry extends Item implements Valuable, Pickable {
    private static int jewelry_id = 1;

    private int price;
    private String name;

    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice(){
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Jewelry(int price, String name) {
        this.price = price;
        this.name = name;
        this.id = jewelry_id++;
    }

    @Override
    public int hashCode() {
        return id ^ (name.hashCode() & price);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Jewelry))
            return false;

        return hashCode() == obj.hashCode();
    }

    @Override
    public String toString() {
        return name + ", стоимость - " + price;
    }
}
