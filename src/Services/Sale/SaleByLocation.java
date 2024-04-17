package Services.Sale;

import Model.GraphCity;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class SaleByLocation {
    public SaleByLocation() throws FileNotFoundException {
        makeCity();
        floyd();
    }
    public String saleByLocation(int x, int y) throws FileNotFoundException {
        int p = (x-1)*5 + y;
        ArrayList<Integer> path = new ArrayList<>();
        for (int i = 0; i < 16; i++){
            path.add(0);
        }

        for(int i = 0; i < 16; i++){
            if(i == 2 || i == 4 || i == 5 || i == 8 || i == 11 || i == 15){
                ArrayList<Integer> tmpPath = new ArrayList<>();
                tmpPath.add(p);
                tmpPath.addAll(path(p,i));
                if(tmpPath.size() < path.size())
                    path = tmpPath;

            }
        }


        return path.toString();




    }

    private void makeCity() throws FileNotFoundException {
        File file = new File("City Map.txt");
        Scanner scanner = new Scanner(file);
        int[][] adj = new int[16][16];
        for(int i = 0; i < 16; i++){
            for(int j = 0; j < 16; j++){
                String ch = scanner.next();
                if(i != j && ch.equals("0")){
                    adj[i][j] = 1000;
                    continue;
                }
                adj[i][j] = Integer.parseInt(ch);
            }
        }
        GraphCity.setAdj(adj);

    }

    private void floyd(){
        int[][] D = GraphCity.getAdj();
        int[][] P = new int[16][16];

        for(int k = 1; k<16; k++){
            for(int i = 1; i < 16; i++){
                for (int j = 1; j < 16; j++) {
                    if(D[i][k] + D[k][j] < D[i][j]){
                        P[i][j] = k;
                        D[i][j] = D[i][k] + D[k][j];
                    }
                }
            }
        }

        GraphCity.setP(P);
        GraphCity.setMinDistance(D);
    }

    private ArrayList<Integer> path(int x, int y){
        int[][] P = GraphCity.getP();
        ArrayList<Integer> ans = new ArrayList<>();

        if(GraphCity.getMinDistance()[x][y] != 0){
//            System.out.println(GraphCity.getMinDistance()[x][y]);
            if(x != 0 && y != 0 && P[x][y] != 0) {
                path(x, P[x][y]);
//                System.out.print("v" + P[x][y] );
                ans.add(P[x][y]);
            }
            if(x != 0 && y != 0)
                path(P[x][y],y);
        }
        ans.add(y);
        return ans;
    }
}
