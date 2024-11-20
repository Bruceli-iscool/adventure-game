package dev.desktop;

import java.io.IOException;

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
        System.out.println(
                "Welcome explorer! The emperor wants to see you!\nChoose a ability to train in\n1 for attack, 2 for defence, 3 for health, 4 for stamina");
        String ans = App.ask(">");
        if ("1".equals(ans.strip())) {
            attack += 1;
        } else if ("2".equals(ans.strip())) {
            defence += 1;
        } else if ("3".equals(ans.strip())) {
            health += 1;
        } else if ("4".equals(ans.strip())) {
            stamina += 1;
        } else {
            System.out.println("Not a valid option!");
            start();
        }
        System.out.println("==============================================================");
        System.out.println("Well explorer, the gates to the imperial palace is open, go see the emperor!");
        Thread.sleep(1000);
        System.out.println("""
                               T~~
                               |
                              /"|
                       T~~    |'| T~~
                       |    /_|_ | |
                      /"|   |     |/|
                     |   |  |     |  |
                     |   |  |     |  |
                     |   |  |     |  |
                     |___|  |     |__|
                     |   |  |  _  |  |
                     |   |  | | | |  |
                     |   |  | | | |  |
                     |   |  |     |  |
                    /_____| |_____| /_____|
                   |       |       |       |
                   |       |        |
                   |_______ |_______|_______|
                """);
        Thread.sleep(500);
        System.out.println("Guards greet you. Greet them back? (+1 stamina) Y, n");
        String n = App.ask(">");
        if ("Y".equals(n)) {
            System.out.println("You greet the guard. The guard greets you back");
            stamina++;
        } else {
            System.out.println("You ignore the guard.");
        }
        Thread.sleep(100);
        System.out.println("The guards leads you into the palace, you see walls with paintings and gold everywhere.");
        Thread.sleep(100);
        System.out.println("The emperor says \"Come in!\"");
        Thread.sleep(200);
        System.out.println(
                "The doors open, you see the emperor his face with wrinkles. 1 to say \"Your Majesty! it is an honor to meet you!\" or 2 (or any other key) to say \"What is it emperor?\"");
        n = App.ask(">");
        if ("1".equals(n)) {
            System.out.println("The emperor says that you must fight the champion orc to start the quest.");
        } else {
            stamina--;
            System.out.println("You disrespectful little piece of garbage, fight the orc or else!");
        }
        Thread.sleep(100);
        System.out.println("""
            ,      ,
          /(.-""-.)\
      ||  |/      |/  /|
      | | / =.  .= | / |
      |( |   o|/o   / )/
       |_, '-/  |-' ,_/
         /   |__/   \
         | |__/|__/ /
       ___| ||--|/ /___
                """);
        Thread.sleep(100); 
        Orc o = new Orc(10, 1, 4, 5);
        while (o.health() > 0){
            System.out.println("""
                Your stats are: 
                attack: """ + attack + "\ndefence: " + defence + "\nhealth: " + health + "\nstamina: " + stamina);
            System.out.println("1 to attack, 2 to block.");
            n = App.ask(">");
            if (n.equals("1")) {
                o.attacked(attack);
                o.turn();
            } else {
                defence = o.attack() - defence;
                health = health-defence+Math.round(stamina/2);
                o.turn();
                continue;
            } 
            health = health-o.attack()+Math.round(stamina/2);

    }
    System.out.println("You killed the Orc Champion!");    
    System.out.println("""
        Your stats are: 
        attack: """ + attack + "\ndefence: " + defence + "\nhealth: " + health + "\nstamina: " + stamina);
    Thread.sleep(1000);
    App.save(attack, defence, health, stamina, 1);
    quest();
}
public void quest() throws InterruptedException {
    //todo
    System.out.println("So it all begins, the emperor says, you must travel north and defeat the Demon King!");
    Thread.sleep(1500);
    System.out.println("""
        _.---****-.       
._   .-'           /|`.     
 .'             / |  `.   
  V              (  ;    |  
  L       _.-  -. `'      |
 / `-. _.'                ;
:            __   ;    _   |
:`-.___.+-*"': `  ;  .' `. |
|`-/     `--*'   /  /  /`. |
: :                  :`.| ;
| |   .           ;/ .' ' / 
: :  / `             :__.'  
 `._.-'       /     |      
  : )         :      ;      
  :----.._    |     /       
 : .-.    `.       /        
  |     `._       /         
  /`-            /          
 :             .'           
  | )       .-'             
   `-----*"'  THE DEVIL KING !!! 
   credit: [bug] @ asciiart.eu
    """);   
}
}
