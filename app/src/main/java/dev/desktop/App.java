package dev.desktop;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
// note: add save/load system
public class App {
    public static int[] save = new int[5];
    public static File saveFile;
    public static void main(String args[]) throws InterruptedException {
        System.out.println("Welcome to Adventure-Game\n================================================================");
        System.out.println("""   
   ____                     
  / ___| __ _ _ __ ___   ___ 
| |  _ / _` | '_ ` _ | / _ |    Adventure game
 | |_| | (_| | | | | | |  __/           by Bruce Li
||____||__,_|_| |_| |_||___|
=============================================================================
""");
        Thread.sleep(100);
        String ns = ask("1 to load a game, 2 to start a new game");
        if ("1".equals(ns)) {
            // implement load
            Thread.sleep(100);
            System.out.println("1 to use default save file, 2 to load a custon savefile");
            ns = ask(">");
            if ("1".equals(ns)) {
                saveFile = new File("game.sav");
                int i = 0;
                try (Scanner scanner = new Scanner(saveFile)) {
                    while (scanner.hasNextLine()) {
                        save[i] = Integer.parseInt(scanner.nextLine());
                        i++;
                    }
                } catch (FileNotFoundException e) {
                    File n = new File("game.sav");
                    try {
                        System.out.println("No default save file found. Please start a new game.");
                        n.createNewFile();

                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
            else {
                saveFile = new File(ask("Enter file path: "));
                int i = 0;
                try (Scanner scanner = new Scanner(saveFile)) {
                    while (scanner.hasNextLine()) {
                        save[i] = Integer.parseInt(scanner.nextLine());
                        i++;
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("No save file with this name found found. Please use a different file.");
                }
                loadSave(save[0], save[1], save[2], save[3], save[4]);
            }
        } else {
            String ans = ask("Create a new character? Y, n");
            if ("Y".equals(ans.strip())) {
                @SuppressWarnings("unused")
                characterCreator c = new characterCreator();
                c.create();
            }
        }
    }
    @SuppressWarnings("resource")
    public static String ask(String input) {
        Scanner scan = new Scanner(System.in);
        System.out.println(input);
        return scan.nextLine();
    }
    public static void loadSave(int a, int d, int h, int s, int l) {
        character n = new character(a, d, h, s);
        switch(l) {
            case 0:
                try {
                    n.start();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case 1:
            break;
        }
    }
}
