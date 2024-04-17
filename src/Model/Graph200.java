package Model;

public class Graph200 {
    private int[][] adj;
    private int x;
    private int y;
    public Graph200(int x, int y){
        this.x = x;
        this.y = y;
        adj = new int[x][y];
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                adj[i][j] = 0;
            }
        }
    }

    public int[][] getAdj() {
        return adj;
    }

    public void setAdj(int[][] adj) {
        this.adj = adj;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
