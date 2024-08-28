package dev.desktop;
import java.util.Scanner;
import dev.desktop.*;
public class App {
    public static void main(String args[]) {
        System.out.println("Welcome to Adventure Game");
        System.out.println();
        String ans = ask("Create a new character? Y, n");
        if ("Y".equals(ans.strip())) {
            characterCreator();
        }
    }
    @SuppressWarnings("resource")
    public static String ask(String input) {
        Scanner scan = new Scanner(System.in);
        System.out.println(input);
        return scan.nextLine();
    }
}
