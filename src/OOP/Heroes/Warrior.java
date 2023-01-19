package OOP.Heroes;

import OOP.Hero;
import OOP.Heroes.Enemy;

public class Warrior extends Hero {

    public Warrior(String firstName, int damage) {
        super(firstName, damage);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        if (enemy.isAlive()){
            System.out.println(getFirstName()+" атакует! ");
            enemy.takeDamage(getDamage());
            if(!enemy.isAlive()){
                System.out.println("Zombie died!");
            }
        }
    }
}
