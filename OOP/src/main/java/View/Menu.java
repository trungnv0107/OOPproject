package View;

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    private static Menu instance;
    public static Menu getInstance(){
        if(instance != null){
            return instance = instance;
        }
        return instance = new Menu();
    }
    public int mainMenu(){
        System.out.println("1. Products manager.");
        System.out.println("2. Order products.");
        System.out.println("3. Show Order.");
        System.out.println("4. Show Customer.");
        System.out.println("0. Exit.");
        return scanner.nextInt();
    }
    public int productManagerMenu(){
        System.out.println("1. Create product.");
        System.out.println("2. Show product list.");
        System.out.println("3. Update product.");
        System.out.println("4. Delete product.");
        System.out.println("5. Back.");
        return scanner.nextInt();
    }
}
