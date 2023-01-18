package com.OOP;

public abstract class Hero {
    private String name;

    public Hero(String name){
        this.name = name;
    }

    public abstract void attackEnemy(Enemy enemy);

    public String getName() {
        return name;
    }
}
