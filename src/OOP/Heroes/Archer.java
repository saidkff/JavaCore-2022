package OOP.Heroes;

import OOP.Hero;

public class Archer extends Hero {

    public Archer(String firstName, int damage) {
        super(firstName, damage);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        if (enemy.isAlive()){
            System.out.println(getFirstName()+" атакует!");
            enemy.takeDamage(getDamage());
            if(!enemy.isAlive()){
                System.out.println("Zombie died!");
            }
        }
    }
}
