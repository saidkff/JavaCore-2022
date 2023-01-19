package OOP;

import OOP.Heroes.Enemy;

public abstract class Hero<T> {
    private String firstName;

    private int damage;

    private T weapon;

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

    public T getWeapon() {
        return weapon;
    }

    public void setWeapon(T weapon) {
        this.weapon = weapon;
    }
}
