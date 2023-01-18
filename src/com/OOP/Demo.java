package com.OOP;

public class Demo {
    public static void main(String[] args) {
        Archer archer = new Archer("Леголас", 14);
        Mage mage = new Mage("Гендольф", 20);
        Warrior warrior = new Warrior("Боромир", 14);
        Enemy zombie = new Enemy("Zombie", 100);

        while (zombie.isAlive()){
            archer.attackEnemy(zombie);
            mage.attackEnemy(zombie);
            warrior.attackEnemy(zombie);
        }
    }
}