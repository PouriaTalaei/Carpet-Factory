package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GraphCity {
    static int[][] adj;
    static int[][] minDistance;

    static int[][] P;
    public GraphCity() throws FileNotFoundException {
        adj = new int[16][16];
        minDistance = new int[16][16];
        P = new int[16][16];
    }


    public static void setAdj(int[][] adj) {
        GraphCity.adj = adj;
    }

    public static int[][] getAdj() {
        return adj;
    }

    public static void setMinDistance(int[][] minDistance) {
        GraphCity.minDistance = minDistance;
    }

    public static int[][] getMinDistance() {
        return minDistance;
    }

    public static int[][] getP() {
        return P;
    }

    public static void setP(int[][] p) {
        P = p;
    }
}
