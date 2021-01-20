package com.sda.model.characters;

public abstract class Enemy implements Vunerable{
    private String name;
    private int currentHealth;
    private int damage;

    public Enemy(String name, int currentHealth, int damage) {
        this.name = name;
        this.currentHealth = currentHealth;
        this.damage = damage;
    }

    @Override
    public void receiveDamage(int points) {
        this.currentHealth -= points;
        if (this.currentHealth <= 0) {
            System.out.println("Dead");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
