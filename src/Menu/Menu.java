package Menu;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    DesignMenu designMenu = new DesignMenu();
    SaleMenu saleMenu = new SaleMenu();

    public Menu() throws FileNotFoundException {
    }

    public void menu() throws FileNotFoundException {
        System.out.println("WELCOME");
        System.out.println("1: Design\n" +
                "2: Sale\n" +
                "0: Exit");

        String ans = scanner.nextLine();
        while (! ans.equals("0")){
            if(ans.equals("1")){
                designMenu.start();

            }
            else if(ans.equals("2")){
                saleMenu.start();
            }
            else {
                error();
            }

            menu();
        }
    }

    private void error(){
        System.out.println("!!!!! WRONG INPUT !!!!!");
    }
}
