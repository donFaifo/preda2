package me.mguerrero;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Graph gr = new Graph(6);
        gr.newLink(1, 2);
        List<Integer> list = gr.getLinksFromNode(1);
        gr.printMatrixToConsole();
    }
}
