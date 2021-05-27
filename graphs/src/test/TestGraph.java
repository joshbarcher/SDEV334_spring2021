package test;

import structures.MyGraph;

public class TestGraph
{
    public static void main(String[] args)
    {
        MyGraph<String> letterGraph = new MyGraph<>();

        letterGraph.addVertex("a");
        letterGraph.addVertex("b");
        letterGraph.addVertex("c");

        letterGraph.addEdge("a", "b");
        letterGraph.addEdge("b", "a");
        letterGraph.addEdge("b", "c");
        letterGraph.addEdge("c", "b");
        letterGraph.addEdge("c", "a");
        letterGraph.addEdge("a", "c");

        System.out.println(letterGraph.bfs("a"));
    }
}
