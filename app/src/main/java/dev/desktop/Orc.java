package dev.desktop;

import java.util.Random;

// code for the orc enemy
public class Orc {
    int health;
    int stamina;
    int attack;
    int defence;
    boolean turn = true;
    public Orc(int h, int s, int a, int d) {
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
        health += 1;}
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
        System.out.println("Orcs health: " + health);
    }
}
