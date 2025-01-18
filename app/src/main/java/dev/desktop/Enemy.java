package dev.desktop;

import java.util.Random;

// code for enemies
public class Enemy {
    int health;
    int stamina;
    int attack;
    int defence;
    boolean turn = true;
    public Enemy(int h, int s, int a, int d) {
        health = h;
        stamina = s;
        attack = a;
        defence = d;

    }

}
