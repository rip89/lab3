package com.company.item;

public class Jewelry extends Item implements Valuable, Pickable {
    private static int jewelry_id = 1;

    private int price;

    private int id;

    public int getPrice(){
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Jewelry(int price, String name) {
        super(name);
        this.price = price;
        this.id = jewelry_id++;
    }

    @Override
    public int hashCode() {
        return id ^ (getName().hashCode() & price);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Jewelry))
            return false;

        return hashCode() == obj.hashCode();
    }

    @Override
    public String toString() {
        return getName() + ", стоимость - " + price + " " + "крон" ; }
}
