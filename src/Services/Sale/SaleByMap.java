package Services.Sale;

import Model.Graph200;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SaleByMap {

    class Similarity{
        int similarity;
        String graph;

        public Similarity(int similarity, String graph) {
            this.similarity = similarity;
            this.graph = graph;
        }
    }
    public String[] searchByMap(Graph200 graph) throws FileNotFoundException {
        String input = graphToStr(graph);
        Similarity[] similarities = new Similarity[5];


        for(int i = 0; i < 5; i++){
            String carpet = readFile(i);
            similarities[i] = new Similarity(sequenceAlignment(carpet,input,0,0),carpet);
        }

        sort(similarities,0,4);
        String[] ans = new String[3];
        for(int i = 0; i < 3; i++){
            ans[i] = strToGraph(similarities[4-i].graph);
        }
        return ans;


    }

    private String graphToStr(Graph200 graph){
        String ans = "";
        for(int i = 0; i < graph.getX(); i++){
            for(int j = 0; j < graph.getY(); j++){
                ans += graph.getAdj()[i][j];
            }
        }

        return ans;
    }

    private String readFile(int i) throws FileNotFoundException {
        File file = new File("factory.txt");
        Scanner scanner = new Scanner(file);
        for(int j = 0; j < i;j++){
            scanner.next();
            scanner.next();
        }
        String ans = scanner.next();
        return ans;
    }

    private int sequenceAlignment(String carpet,String input, int i, int j){
        int ans = 0;
        int opt;
        int penalty;
        if(i == carpet.length() -1)
            opt = 2*(input.length() - j + 1);
        else if (j == input.length() - 1)
            opt = 2 * (input.length() - j + 1);
        else{
            if(carpet.charAt(i) == input.charAt(j))
                penalty = 0;
            else
                penalty = 1;
            opt = Math.min(sequenceAlignment(carpet,input,i+1,j)+2,sequenceAlignment(carpet,input,i,j+1)+2);
            ans = Math.min(sequenceAlignment(carpet,input,i+1,j+1)+penalty,opt);
        }
        return ans;
    }

    private int partition(Similarity arr[], int low, int high)
    {
        Similarity pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j].similarity <= pivot.similarity)
            {
                i++;

                // swap arr[i] and arr[j]
                Similarity temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        Similarity temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    private void sort(Similarity arr[], int low, int high)
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
