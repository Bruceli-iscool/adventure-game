package dev.desktop;

import java.io.IOException;
import java.util.Random;
// todo story
class character {
    int attack, defence, health, stamina;

    public character(int a, int d, int h, int s) {
        attack = a;
        defence = d;
        health = h;
        stamina = s;
    }

    public void start() throws InterruptedException, IOException {
        App.save(attack, defence, health, stamina, 0);
        System.out.println(
                "=============================================================================\nPrologue\n===============================================================================");
        Thread.sleep(100);
        Thread.sleep(100); 
        Orc o = new Orc(10, 1, 4, 5);
        while (o.health > 0 && health > 0){
            System.out.println("""
                Your stats are: 
                attack: """ + attack + "\ndefence: " + defence + "\nhealth: " + health + "\nstamina: " + stamina);
            System.out.println("1 to attack, 2 to block.");
            String n = App.ask(">");
            if (n.equals("1")) {
                Random k = new Random();
                int c = k.nextInt(4);
                if (c== 0) {
                    System.out.println("Your attack failed!");
                } else {
                o.attacked(attack);
                o.printStats();
                o.turn();}
            } else {
                defence = o.attack() - defence;
                health = health-defence+Math.round(stamina/2);
                o.turn();
                continue;
            } 
            health = health-o.attack()+Math.round(stamina/2);


    }
    if (health < 1) {
        System.out.println("Game Over!");
        System.exit(0);
    }
    System.out.println("You killed the Orc!");    
    System.out.println("""
        Your stats are: 
        attack: """ + attack + "\ndefence: " + defence + "\nhealth: " + health + "\nstamina: " + stamina);
    Thread.sleep(1000);
    App.save(attack, defence, health, stamina, 1);
    quest();
}
public void quest() throws InterruptedException {
    System.out.println("=========================================================Chapter 1====================================================================");

}
}
