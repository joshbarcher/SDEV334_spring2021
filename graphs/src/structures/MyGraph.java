package structures;

import adts.IDirectedGraph;
import adts.IWeightedGraph;

import java.util.Set;

public class MyGraph<V> implements IDirectedGraph<V>, IWeightedGraph<V>
{
    //TODO complete our graph...

    @Override
    public boolean addVertex(V vertex)
    {
        return false;
    }

    @Override
    public boolean addEdge(V tail, V head)
    {
        return false;
    }

    @Override
    public boolean containsVertex(V search)
    {
        return false;
    }

    @Override
    public boolean containsEdge(V tail, V head)
    {
        return false;
    }

    @Override
    public boolean removeVertex(V vertex)
    {
        return false;
    }

    @Override
    public boolean removeEdge(V tail, V head)
    {
        return false;
    }

    @Override
    public void clear()
    {

    }

    @Override
    public int vertexSize()
    {
        return 0;
    }

    @Override
    public int edgeSize()
    {
        return 0;
    }

    @Override
    public boolean isVertexSetEmpty()
    {
        return false;
    }

    @Override
    public boolean isEdgeSetEmpty()
    {
        return false;
    }

    @Override
    public Set<V> vertexSet()
    {
        return null;
    }

    @Override
    public Set<Edge<V>> edgeSet()
    {
        return null;
    }

    @Override
    public Set<V> adjacentVertices(V source)
    {
        return null;
    }

    @Override
    public Set<Edge<V>> incidentEdges(V source)
    {
        return null;
    }

    @Override
    public int inDegree(V source)
    {
        return 0;
    }

    @Override
    public int outDegree(V source)
    {
        return 0;
    }

    @Override
    public boolean isGraphWeaklyConnected()
    {
        return false;
    }

    @Override
    public boolean isGraphStronglyConnected()
    {
        return false;
    }

    @Override
    public boolean addEdge(V tail, V head, int weight)
    {
        return false;
    }

    @Override
    public int edgeWeight(V tail, V head)
    {
        return 0;
    }
}
