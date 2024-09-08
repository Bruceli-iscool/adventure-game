package dev.desktop;
class character {
    int attack, defence, health, stamina;
    public character(int a, int d, int h, int s) {
        attack = a;
        defence = d;
        health = h;
        stamina = s;
    }
    public void start() throws InterruptedException {
        System.out.println("Welcome explorer! The emperor wants to see you!\nChoose a ability to train in\n1 for attack, 2 for defence, 3 for health, 4 for stamina");
        String ans = App.ask(">");
        if ("1".equals(ans.strip())) {
            attack += 1;
        }
        else if ("2".equals(ans.strip())) {
            defence += 1;
        }
        else if ("3".equals(ans.strip())) {
            health += 1;
        }
        else if ("4".equals(ans.strip())) {
            stamina += 1;
        }
        else {
            System.out.println("Not a valid option!");
            start();
        }
        System.out.println("""
                           Your stats are: 
                           attack: """ + attack + "\ndefence: " + defence + "\nhealth: " + health + "\nstamina: " + stamina);
    
        System.out.println("Adventurer, the. kingdom is crumbling!\nThe army of death has aprroached, destorying the southern lands\nI will not live, deliver to the heir the Kings Crown!");
        Thread.sleep(1000);
        System.out.println(">\nYou recieved the Kings Crown."); 
        pathOne();
    }
    public void pathOne() {

    }

}

