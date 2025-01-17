package dev.desktop;

import java.util.Random;

// code for the Bandit enemy
public class Bandit {
    int health;
    int stamina;
    int attack;
    int defence;
    boolean turn = true;
    public Bandit(int h, int s, int a, int d) {
        health = h;
        stamina = s;
        attack = a;
        defence = d;

    }

    public boolean attacked(int damage) {
        health = defence - damage;
        turn = true;
        if (health < 0) {
            return false;
        } else {
            return true;
        }

    }
    public void turn() {
        if (health >0 ) {
            health += 3;}
    }
    public int attack() {
        Random n = new Random();
        int c = n.nextInt(3);
        if (c != 0) {
            return attack;}
        else {
            return 0;
        }
    }
    public int health() {
        return health;
    }
    public void printStats() {
        System.out.println("Bandits health: " + health);
    }
}

