package dev.desktop;
class characterCreator {
    int attack, defence, health, stanima;
    public characterCreator() {
        System.out.println("You have 20 points to spend on 4 abilities. Each stat has a 10 point limit");
        int points = 20;
        attack = Integer.parseInt(App.ask("Enter Attack: "));
        if (attack > 10) {
            // if bigger than 10, just make attack 10
            attack = 10;
            points = points - 10;
        } else {
            points = points - attack;
        }
        System.out.println("You now have: " + points + " points");
        defence = Integer.parseInt(App.ask("Enter defence: "));
        if (defence > 10) {
            defence = 10;
            points = points - defence;
        }
    }
}