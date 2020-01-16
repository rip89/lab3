package com.company.item;

public class Money extends Item implements Valuable, Pickable {

    private String currency;
    private int price;

    public Money(String currency, int price) {
        super(price + " " + currency);
        this.currency = currency;
        this.price = price;
    }

    public int getPrice(){
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        return price ^ currency.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Money))
            return false;

        return hashCode() == obj.hashCode();
    }

    @Override
    public String toString() { return getName(); }
}
