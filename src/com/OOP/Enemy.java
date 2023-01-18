package com.OOP;

public class Enemy implements Mortal{
    private String name;
    private int health;

    public Enemy(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public void takeDamage(int damage){
        health -= Math.min(health, damage);
        System.out.println(name+ " получил урон: "+damage + " Остался: " +health);
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

}
