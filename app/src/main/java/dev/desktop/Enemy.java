package dev.desktop;

import java.util.Random;

// code for enemies
public class Enemy {
    Random k = new Random();
    int health;
    int stamina;
    int attack;
    int defence;
    public Enemy(int h, int s, int a, int d) {
        health = h;
        stamina = s;
        attack = a;
        defence = d;

    }
    int attack() {
        int c = k.nextInt(4);
        if (c == 0) {
            return 0;
        }else {
            return attack;
        }

    }
    void attacked(int damage) {
        health = health - (damage) ;
    }
    void stats() {
        System.out.println("Orcs Health: " + health);
    }
}
