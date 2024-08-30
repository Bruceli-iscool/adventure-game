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
            // bigger than 10
            defence = 10;
            points = points - defence;
        } else {
            points = points - defence;
        }
        if (points <= 0) {
            System.out.println("Character creation complete.");
            review();
        }
        System.out.println("You now have: " + points + " points");
        health = Integer.parseInt(App.ask("Enter health: "));
        if (health > 10 && points >= 10) {
            // bigger than 10
            health = 10;
            points = points - health;
        } else if (health > points) {
            health = points;
            points = points - health;
        } else {
            points = points - health;
        }
        if (points <= 0) {
            System.out.println("Character creation complete.");
            review();
        }
        System.out.println("You now have: " + points + " points");
        stanima = Integer.parseInt(App.ask("Enter stamina: "));
        if (stanima > 10 && points > 10) {
            // bigger than 10
            stanima = 10;
            points = points - stanima;
        }else if (stanima > points) {
            stanima = points;
            points = points - stanima;
        }
         else {
            points = points - stanima;
        }
        System.out.println("Character creation complete.");
        review();
        int b = points;
        points = b;
        b = points;
        
        
    }
    private void review() {
        if (health <= 0) {
            // prevent health from being zero
            health = 1;
        }
        System.out.println("""
                           Your stats are: 
                           attack: """ + attack + "\ndefence: " + defence + "\nhealth: " + health + "\nstamina: " + stanima);
    }
    public void create() {
        character c = new character(attack, defence, health, stanima);
        c.start();
    }
}