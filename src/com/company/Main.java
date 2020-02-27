package com.company;
import com.company.entity.*;
import com.company.item.*;

public class Main {

    public static void main(String[] args) {
        Money money = new Money("шекелей", 15);
        Jewelry brooch = new Jewelry(10,  "брошки");
        Jewelry ring = new Jewelry(20, "кольцо");

        PickableItem sheet = new PickableItem("скатерть");
        PickableItem tissue = new PickableItem("салфетка");

        Furniture secretary = new Furniture(3, "секретер");

        Furniture locker1 = new Furniture(5, "ящик");
        locker1.put(money);

        Furniture locker2 = new Furniture(5, "ящик");
        locker2.put(brooch);

        Furniture locker3 = new Furniture(5, "ящик");
        locker3.put(ring);

        secretary.put(locker1);
        secretary.put(locker2);
        secretary.put(locker3);

        Furniture sideboard = new Furniture(20, "буфет");
        sideboard.put(sheet);
        sideboard.put(tissue);

        Furniture couch = new Furniture(5, "диван");
        Furniture table = new Furniture(5, "стол");

        Thief Fille = new Thief("Филле", true, 10, Location.KITCHEN);
        Thief Rulle = new Thief("Рулле", true, 10, Location.DINING_ROOM);
        Human Lilebror = new Human( "Малыш", true, Location.LIVING_ROOM);
        Human Crister = new Human("Кристер", true, Location.LIVING_ROOM);
        Human Gunilla = new Human("Гунилла", false, Location.LIVING_ROOM);
        Ghost ghost = new Ghost(Location.DINING_ROOM, "Карлсон");
        Dog dog = new Dog("Эффи", false, Location.LIVING_ROOM);

        Reaction dropReaction = new Reaction() {
            @Override
            public void apply(Human human) {
                human.rattle();
                human.fear(10);
                if (human instanceof Thief) {
                    ( (Thief) human ).drop();
                }
            }
        };

        Lilebror.fear(15);
        Crister.fear(8);
        Gunilla.fear(8);
        Crister.moveDog(dog, Location.BEDROOM);
        dog.move(Location.BEDROOM, 5);
        ghost.fear(0);

        System.out.println();

        ghost.move(Location.DINING_ROOM, 0);
        Lilebror.move(Location.DINING_ROOM, 0);
        Crister.move(Location.DINING_ROOM, 0);
        Gunilla.move(Location.DINING_ROOM, 0);

        ghost.hide(sideboard);
        Lilebror.hide(couch);
        Crister.hide(table);
        Gunilla.hide(table);

        System.out.println();

        Fille.move(Location.DINING_ROOM, 3);
        Rulle.move(Location.DINING_ROOM, 3);

        Fille.move(Location.KITCHEN, 7);
        Rulle.pickAll(secretary);

        System.out.println();

        ghost.unhide();
        ghost.groan(16);
        ghost.scare(Rulle, dropReaction);
        ghost.sigh();
        ghost.groan(20);

        System.out.println();

        ghost.move(Location.KITCHEN, 0);
        Fille.move(Location.DINING_ROOM, 7);
        ghost.scare( Fille, target -> {
            System.out.printf("%s бледен как полотно!\n", target.getName());
            target.fear(10);
        } );

        System.out.println();

        ghost.move(Location.DINING_ROOM, 10);
        ghost.sigh();
        ghost.groan(40);
        ghost.flutter(Rulle);
        ghost.flutter(Fille);

        System.out.println();

        Fille.move(Location.HALL, 20);
        Rulle.move(Location.HALL, 20);
        ghost.move(Location.HALL, 10);
        ghost.groan(25);

        Rulle.move(Location.STAIRWAY, 50);
        Fille.move(Location.STAIRWAY, 50);
        ghost.groan(50);
        ghost.move(Location.STAIRWAY, 30);
    }
}
