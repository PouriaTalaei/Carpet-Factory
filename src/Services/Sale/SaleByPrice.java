package Services.Sale;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SaleByPrice {
    public class CarpetPrice{
        String graph;
        int price;

        public CarpetPrice(String graph, int price) {
            this.graph = graph;
            this.price = price;
        }
    }
    public String searchByPrice(int budget) throws FileNotFoundException {
        CarpetPrice[] carpetPrices = new CarpetPrice[5];
        for(int i = 0; i < 5; i++){
            carpetPrices[i] = readFile(i);
        }

        sort(carpetPrices,0,4);
        ArrayList<CarpetPrice> found = findByBudget(carpetPrices,budget);
        String ans = arrayListToStr(found);

        return ans;


    }

    private CarpetPrice readFile(int i) throws FileNotFoundException {
        File file = new File("factory.txt");
        Scanner scanner = new Scanner(file);
        for(int j = 0; j < i; j++){
            String graph = scanner.next();
            int price = scanner.nextInt();
        }
        String graph = scanner.next();
        int price = scanner.nextInt();

        return new CarpetPrice(graph,price);
    }

    private int partition(CarpetPrice arr[], int low, int high)
    {
        CarpetPrice pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j].price <= pivot.price)
            {
                i++;

                // swap arr[i] and arr[j]
                CarpetPrice temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        CarpetPrice temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    private void sort(CarpetPrice arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is
              now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before
            // partition and after partition
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }

    private ArrayList<CarpetPrice> findByBudget(CarpetPrice[] carpetPrice, int budget){
        ArrayList<CarpetPrice> ans = new ArrayList<>();
        int money = 0;
        for(int i = 0; i < carpetPrice.length; i++){
            money += carpetPrice[i].price;
            if(money <= budget)
                ans.add(carpetPrice[i]);
            else
                break;
        }
        return ans;
    }

    private String arrayListToStr(ArrayList<CarpetPrice> arrayList){
        String ans = "";
        for(int i = 0; i < arrayList.size(); i++){
            ans += "Map:\n" + strToGraph(arrayList.get(i).graph);
            ans += "price: " + arrayList.get(i).price;
            ans += "\n\n";
        }

        return ans;
    }
    private String strToGraph(String str){
        String ans = "";
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 20; j++){
                ans += str.charAt(i*20+j);
            }
            ans += "\n";
        }
        return ans;
    }


}
