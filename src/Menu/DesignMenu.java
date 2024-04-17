package Menu;

import Services.DesignService;

import java.util.ArrayList;
import java.util.Scanner;

public class DesignMenu {
    Scanner scanner = new Scanner(System.in);
    DesignService designService = new DesignService();
    public void start(){
        System.out.println("NUMBER OF VERTICES:");
        int n = scanner.nextInt();
        System.out.println("WHAT VERTICES ARE CONNECTED TOGETHER?\n" +
                "0 0: END");

        int x = scanner.nextInt();
        int y = scanner.nextInt();
        ArrayList<Integer> input = new ArrayList<>();
        while (x != 0){
            input.add(x);
            input.add(y);
            x = scanner.nextInt();
            y = scanner.nextInt();
        }
        System.out.println(designService.start(input,n).toString());
    }

}
