package OOP;

import OOP.Heroes.Enemy;

public abstract class Hero {
    private String firstName;

    private int damage;

    public Hero(String firstName, int damage) {
        this.firstName = firstName;
        this.damage = damage;
    }

    public abstract void attackEnemy(Enemy enemy);

    public String getFirstName() {
        return firstName;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
