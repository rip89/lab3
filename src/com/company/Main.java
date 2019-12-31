package com.company;
import com.company.entity.Ghost;
import com.company.entity.Human;
import com.company.entity.Room;
import com.company.item.Furniture;
import com.company.item.Jewelry;
import com.company.item.Money;

public class Main {

    public static void main(String[] args) {


        Money money = new Money("шекелей", 15);
        Jewelry brooch = new Jewelry(10,  "брошки");
        Jewelry ring = new Jewelry(20, "кольцо");

        Furniture secretary = new Furniture(20, "сектретер");
        Furniture sideboard= new Furniture(20, "буфет");


        Human Fille = new Human("Филле", true, 10, Room.KITCHEN);
        Human Rulle = new Human("Рулле", true, 10, Room.DINING_ROOM);
        Ghost ghost = new Ghost(Room.DINING_ROOM, "Карлсон");

        Fille.move(Room.KITCHEN);
        Rulle.use(secretary);
        Rulle.pick(money);
        Rulle.use(secretary);
        Rulle.pick(ring);
        Rulle.pick(brooch);
        ghost.use(sideboard);
        ghost.groan(16);
        Rulle.rattle();
        Rulle.drop();
        ghost.flutter(Rulle);
        ghost.sigh();
        ghost.groan(20);
        ghost.move(Room.KITCHEN);
        Fille.move(Room.DINING_ROOM);

    }
}
