package Services;

import Model.DesignAnswer;
import Model.Graph;

import java.util.ArrayList;

public class DesignService {

    public DesignAnswer start(ArrayList<Integer> arr, int n){
        Graph graph = new Graph(n);
        for (int i = 0; i < arr.size(); i++){
            graph.addEdge(arr.get(i),arr.get(++i));
        }

        return findMinM(graph);

    }
    private DesignAnswer findMinM(Graph graph){
        int V = graph.getN();
        Integer[] color = new Integer[V+1];
        DesignAnswer ans = new DesignAnswer(color,0);

        int[][] g = graph.getAdj();


        int m;
        for(m = 2; m < V+1; m++) {
            for(int i = 0; i < V+1; i++){
                color[i] = 0;
            }
            if(graphColoring(g, m, 1, color,V)){
                ans = new DesignAnswer(color,m);
                break;
            }
        }

        return ans;
    }




    // check if the colored
    // graph is safe or not
    static boolean isSafe(int[][] graph, Integer[] color, int i)
    {
        // check for every edge
        for(int j = 1; j < i; j++){
            if(graph[j][i] == 1 && color[i].equals(color[j]))
                return false;
        }

        return true;
    }

    /* This function solves the m Coloring
      problem using recursion. It returns
      false if the m colours cannot be assigned,
      otherwise, return true and prints
      assignments of colours to all vertices.
      Please note that there may be more than
      one solution, this function prints one
      of the feasible solutions.*/
    static boolean graphColoring(int[][] graph, int m,
                                 int i, Integer[] color, int V) {
        // if current index reached end
        if (i == V + 1) {

            // if coloring is safe
            if (isSafe(graph, color, V)) {
                return true;
            }
            return false;
        }

        // Assign each color from 1 to m
        for (int j = 1; j <= m; j++) {
            color[i] = j;
            if(isSafe(graph,color,i)){
                if(graphColoring(graph,m,i+1,color,V))
                    return true;
            }



        }
        return false;
    }



}
