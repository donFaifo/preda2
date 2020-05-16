package me.mguerrero;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Graph gr;

    public static void main(String[] args) {
        int opt=0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("MENÚ");
            System.out.println("--------------------");
            System.out.println("1. Crear grafo");
            System.out.println("2. Añadir link");
            System.out.println("3. Imprimir matriz");
            System.out.println("4. Imprimir nodos adyacentes");
            System.out.println("0. Salir");
            System.out.print("> ");
            opt = sc.nextInt();
            switch(opt)
            {
                case 1:
                    createGraphOption();
                    break;
                case 2:
                    addLinkOption();
                    break;
                case 3:
                    gr.printMatrixToConsole();
                    break;
                case 4:
                    printAdjancentListOption();
                    break;
                default:
                    opt=0;
            }

        } while(opt!=0);
    }

    private static void createGraphOption()
    {
        int nodesNumber;
        Scanner sc = new Scanner(System.in);
        System.out.print("Número de nodos: ");
        nodesNumber = sc.nextInt();
        gr = new Graph(nodesNumber);
    }

    private static void addLinkOption()
    {
        int node1;
        int node2;
        int weight;

        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Nodo de partida (0 para salir): ");
            node1 = sc.nextInt();
            if (node1!=0)
            {
                System.out.print("Nodo de destino: ");
                node2 = sc.nextInt();
                System.out.print("Peso del link: ");
                weight = sc.nextInt();
                gr.newLink(node1, node2, weight);
            }
        } while (node1!=0);
    }

    private static void printAdjancentListOption()
    {
        int nodeOrigin;
        List<Integer> adjacentList = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Nodo de partida (0 para salir): ");
            nodeOrigin = sc.nextInt();
            if (nodeOrigin!=0)
            {
                adjacentList = gr.getLinksFromNode(nodeOrigin);
                if (!adjacentList.isEmpty())
                {
                    System.out.printf("Nodo orígen: %d\n", nodeOrigin);
                    System.out.print("Nodos adyacentes:\n");
                    System.out.print(adjacentList.get(0));
                    for (int i=1; i<adjacentList.size(); i++) {
                        System.out.printf(" - %d", adjacentList.get(i));
                    }
                    System.out.println();
                }
            }
        } while (nodeOrigin!=0);
    }
}
