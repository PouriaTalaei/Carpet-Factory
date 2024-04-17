package Model;

import java.util.ArrayList;

public class Graph {
    int[][] adj;
    private int n;
    public Graph(int n){
        this.n = n;
        this.adj = new int[n+1][n+1];
        for(int i = 0; i < n+1; i++){
            for (int j = 0; j < n+1; j++){
                adj[i][j] = 0;
            }
        }
    }
    public int getN(){
        return n;
    }
    public int[][] getAdj(){
        return adj;
    }

    public void addEdge(int u, int v) {
        adj[u][v] = 1;
        adj[v][u] = 1;
    }

}
