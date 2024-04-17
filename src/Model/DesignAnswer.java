package Model;

import java.util.Arrays;

public class DesignAnswer {
    Integer[] color;
    int m;

    public DesignAnswer(Integer[] color, int m) {
        this.color = color;
        this.m = m;
    }

    @Override
    public String toString() {
        StringBuilder colour = new StringBuilder();
        for (int i = 1; i < color.length; i++) {
            colour.append("\tarea").append(i).append(": ").append(color[i]).append("\n");
        }
        return
                "colors=\n" + colour+"\n"+
                "m= " + m ;
    }
}
