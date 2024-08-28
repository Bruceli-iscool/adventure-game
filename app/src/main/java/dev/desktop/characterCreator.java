package dev.desktop;
public class characterCreator {
    int attack, defence, health, stanima;
    public void characterCreator() {
        System.out.println("You have 20 points to spend on 4 abilities. Each stat has a 10 point limit");
        int points = 20;
        attack = Integer.getInteger(App.ask("Enter Attack: "));
        if (attack > 10) {
            attack = 10;
            points = points - 10;
        } else {
            points = points - attack;
        }
        
    }
}