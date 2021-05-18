package adts;

import structures.Edge;

import java.util.Set;

public interface IDirectedGraph<V>
{
    //add, contains, remove, clear
    boolean addVertex(V vertex);
    boolean addEdge(V tail, V head);
    boolean containsVertex(V search);
    boolean containsEdge(V tail, V head);
    boolean removeVertex(V vertex);
    boolean removeEdge(V tail, V head);
    void clear();

    //count of elements
    int vertexSize();
    int edgeSize();
    boolean isVertexSetEmpty();
    boolean isEdgeSetEmpty();

    //get our vertices and edges
    Set<V> vertexSet();
    Set<Edge<V>> edgeSet();

    //fun methods
    Set<V> adjacentVertices(V source);
    Set<Edge<V>> incidentEdges(V source);
    int inDegree(V source);
    int outDegree(V source);
    boolean isGraphWeaklyConnected();
    boolean isGraphStronglyConnected();
}









