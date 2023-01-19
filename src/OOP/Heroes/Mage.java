package OOP.Heroes;

import Generics.Weapons.MagicWeapon;
import OOP.Hero;
import OOP.Heroes.Enemy;

public class Mage<T extends MagicWeapon> extends Hero<T> {
    public Mage(String firstName, int damage) {
        super(firstName, damage);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        if (enemy.isAlive()){
            System.out.println(getFirstName() + " атакует!");
            enemy.takeDamage(getDamage());
            if(!enemy.isAlive()){
                System.out.println("Zombie died!");
            }
        }
    }
}
