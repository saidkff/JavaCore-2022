package com.OOP;

public class Archer extends Hero{
    private int damage;
    public Archer(String name, int damage) {
        super(name);
        this.damage = damage;
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        if (enemy.isAlive()){
            System.out.println(getName()+" атакует! ");
            enemy.takeDamage(getDamage());
            if (!enemy.isAlive()){
                System.out.println("Zombie died!");
            }
        }
    }

    public int getDamage() {
        return damage;
    }
}
