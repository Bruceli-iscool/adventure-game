package dev.desktop;
class character {
    int attack, defence, health, stamina;
    public character(int a, int d, int h, int s) {
        attack = a;
        defence = d;
        health = h;
        stamina = s;
    }
    public void start() {
        System.out.println("Welcome explorer! The emperor wants to see you!\nChoose a ability to train in\n1 for attack, 2 for defence, 3 for health, 4 for stamina");
        String ans = App.ask(">");
        if ("1".equals(ans.strip())) {
            attack += 1;
        }
        if ("2".equals(ans.strip())) {
            defence += 1;
        }
        if ("3".equals(ans.strip())) {
            health += 1;
        }
        if ("4".equals(ans.strip())) {
            stamina += 1;
        }
        else {
            System.out.println("Not a valid option!");
            start();
        }
        System.out.println("==============================================================");
        System.out.println("Well explorer, the gates to the imperial palace is open, go see the emperor!");
        System.out.println("""               
               T~~
               |
              /"\
       T~~    |'| T~~
       |    /_|_ | |
      /"|   |     |/\
     |   |  |     |  |
     |   |  |     |  |
     |   |  |     |  |
     |___|  |     |__|
     |   |  |  _  |  |
     |   |  | | | |  |
     |   |  | | | |  |
     |   |  |     |  |
    /_____| |_____| /_____\
   |       |       |       |
   |       |        |
   |_______ |_______|_______|
""");
    System.out.println("Guards greet you. Greet them back? (+1 stamina) Y, n");
    String n = App.ask(">");
    if ("Y".equals(n)) {
        System.out.println("You greet the guard. The guard greets you back");
        stamina++;
    } else {
        System.out.println("You ignore the guard.");
    }
    }
}

