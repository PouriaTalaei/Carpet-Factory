package Menu;

import Model.Graph200;
import Services.Sale.SaleByLocation;
import Services.Sale.SaleByMap;
import Services.Sale.SaleByPrice;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class SaleMenu {
    Scanner scanner = new Scanner(System.in);
    SaleByMap saleByMap = new SaleByMap();
    SaleByPrice saleByPrice = new SaleByPrice();
    SaleByLocation saleByLocation = new SaleByLocation();

    public SaleMenu() throws FileNotFoundException {
    }

    public void start() throws FileNotFoundException {
        System.out.println("1: Sale By Design\n" +
                "2: Sale By Price\n" +
                "3: Nearest Shop\n" +
                "0: Back");

        String ans = scanner.nextLine();
        while (! ans.equals("0")){
            if(ans.equals("1")){
                saleByDesign();
            }
            else if (ans.equals("2")){
                saleByPrice();
            }
            else if (ans.equals("3")){
                nearest();
            }
            else {
                System.out.println("!!!!! WRONG INPUT !!!!!");
            }
            start();

        }
    }

    private void saleByDesign() throws FileNotFoundException {
        System.out.println("ENTER M =");
        int m = scanner.nextInt();
        System.out.println("ENTER N =");
        int n = scanner.nextInt();
        System.out.println("ENTER THE MAP =");

        int[][] input = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                input[i][j] = scanner.nextInt();
            }
        }
        Graph200 graph = new Graph200(m,n);
        graph.setAdj(input);

        String[] ans = saleByMap.searchByMap(graph);
        for (int i = 0; i < 3; i++) {
            System.out.println(ans[i]);
        }
        scanner.nextLine();

    }

    private void saleByPrice() throws FileNotFoundException {
        System.out.println("ENTER YOUR BUDGET =");
        int budg = scanner.nextInt();

        System.out.println(saleByPrice.searchByPrice(budg));
    }

    private void nearest() throws FileNotFoundException {
        System.out.println("ENTER YOUR X =");
        int x = scanner.nextInt();
        System.out.println("ENTER YOUR Y =");
        int y = scanner.nextInt();

        System.out.println(saleByLocation.saleByLocation(x,y));
        scanner.nextLine();
    }
}
