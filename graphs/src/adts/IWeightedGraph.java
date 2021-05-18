package adts;

public interface IWeightedGraph<V>
{
    boolean addEdge(V tail, V head, int weight);
    int edgeWeight(V tail, V head);
}
