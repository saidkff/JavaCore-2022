package OOP;

import OOP.Heroes.Archer;
import OOP.Heroes.Enemy;
import OOP.Heroes.Mage;
import OOP.Heroes.Warrior;

public class Demo {
    public static void main(String[] args) {
        Archer archer = new Archer("Леголас", 15);
        Mage mage = new Mage("Гендольф", 20);
        Warrior warrior = new Warrior("Боромир", 14);
        Enemy enemy = new Enemy("Zombie", 100);

        while (enemy.isAlive()){
            archer.attackEnemy(enemy);
            mage.attackEnemy(enemy);
            warrior.attackEnemy(enemy);
        }
    }
}
