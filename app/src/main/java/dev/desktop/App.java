package dev.desktop;
import java.util.Scanner;
public class App {
    public static void main(String args[]) {
        System.out.println("Welcome to Adventure-Game\n================================================================");
        System.out.println("""   
   ____                     
  / ___| __ _ _ __ ___   ___ 
| |  _ / _` | '_ ` _ | / _ |    Adventure game
 | |_| | (_| | | | | | |  __/           by Bruce Li
||____||__,_|_| |_| |_||___|
=============================================================================
""");
        System.out.println();
        String ans = ask("Create a new character? Y, n");
        if ("Y".equals(ans.strip())) {
            @SuppressWarnings("unused")
            characterCreator c = new characterCreator();
            c.create();
        }
    }
    @SuppressWarnings("resource")
    public static String ask(String input) {
        Scanner scan = new Scanner(System.in);
        System.out.println(input);
        return scan.nextLine();
    }
}
