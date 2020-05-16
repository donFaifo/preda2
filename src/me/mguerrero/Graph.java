package me.mguerrero;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for building a Graph through its matrix
 */
public class Graph {
    private int [][] matrix;
    List<Integer> nodes;

    /**
     * Constructor for objects of class Graph1
     */
    public Graph(int nodesNumber)
    {
        nodes=new ArrayList<>();
        matrix = new int[nodesNumber][nodesNumber];
        for (int i=0; i<nodesNumber; i++)
        {
            for (int j=0; j<nodesNumber; j++)
            {
                matrix[i][j] = 0;
            }
            nodes.add(i, i+1);
        }
    }

    /**
     * creates a directed link from node1 to node2
     *
     * @param node1 the initial node
     * @param node2 the destination node
     */
    public void newLink(int node1, int node2)
    {
        matrix[node1-1][node2-1] = 1;
    }

    /**
     * overload of newLink with weights for the links
     * @param node1 the start node
     * @param node2 the destination node
     * @param weight weight of the link
     */
    public void newLink(int node1, int node2, int weight)
    {
        matrix[node1-1][node2-1] = weight;
    }

    /**
     * Return the list of nodes which are connected to the param node
     * @param node node to get the links from
     * @return List of integer nodes
     */
    public List<Integer> getLinksFromNode(int node)
    {
        List<Integer> resultList = new ArrayList<>();
        for (int i=0; i<nodes.size(); i++)
        {
            if(matrix[node-1][i]!=0)
            {
                resultList.add(i+1);
            }
        }

        return resultList;
    }

    /**
     * Prints the matrix on the console
     */
    public void printMatrixToConsole()
    {
        System.out.print("    ");
        for (int i=0; i<nodes.size(); i++)
        {
            System.out.printf("%4d", i+1);
        }
        System.out.print("\n");

        System.out.print("    ");
        for (int i=0; i<nodes.size(); i++)
        {
            System.out.print("----");
        }
        System.out.print("\n");

        for (int i=0; i<nodes.size(); i++)
        {
            System.out.printf("%2d| ", i+1);
            for(int j=0; j<nodes.size();j++)
            {
                if (matrix[i][j]!=0)
                {
                    System.out.printf("%4d", 1);
                } else
                {
                    System.out.printf("%4d", 0);
                }
            }
            System.out.print("\n");
        }
    }
}
