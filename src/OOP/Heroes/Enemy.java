package OOP.Heroes;

import OOP.Mortal;

public class Enemy implements Mortal {
    private String name;
    private int health;

    public Enemy(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public void takeDamage(int damage){
        health-=Math.min(health, damage);
        System.out.println(getName() + " получил урон " + damage + " остался "+ getHealth());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public boolean isAlive() {
        return health>0;
    }
}
