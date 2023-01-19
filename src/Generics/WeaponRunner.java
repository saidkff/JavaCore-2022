package Generics;

import Generics.Weapons.*;
import OOP.Hero;
import OOP.Heroes.Archer;
import OOP.Heroes.Mage;
import OOP.Heroes.Warrior;

public class WeaponRunner {
    public static void main(String[] args) {
        Archer<Bow> archer = new Archer<>("Леголас", 20);
        archer.setWeapon(new Bow());
        Warrior<Sword> warrior = new Warrior<>("Боромир", 15);
        warrior.setWeapon(new Sword());
        Mage<Wand> mage = new Mage<>("Гендольф", 25);
        mage.setWeapon(new Wand());
        System.out.println(mage.getWeapon().getDamage());

        printWeaponDamage(archer);
    }

    public static <T extends Weapon> void printWeaponDamage(Hero<T> hero){
        System.out.println(hero.getWeapon().getDamage());
    }

//    public static void printWeaponDamage(Hero<? extends Weapon> hero){
//        System.out.println(hero.getWeapon().getDamage());
//    }
}
