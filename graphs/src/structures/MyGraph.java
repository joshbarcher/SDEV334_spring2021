package structures;

import adts.IDirectedGraph;
import adts.IWeightedGraph;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * This is a graph that is directed and weighted. The graph
 * is based on adjacency lists.
 *
 * @param <V>
 */
public class MyGraph<V> implements IDirectedGraph<V>, IWeightedGraph<V>
{
    private Map<V, Node> adjLists;
    private int size;

    public MyGraph()
    {
        this.adjLists = new HashMap<>();
    }

    @Override
    public boolean addVertex(V vertex)
    {
        //preconditions...
        if (containsVertex(vertex))
        {
            return false;
        }

        adjLists.put(vertex, null);
        size++;
        return true;
    }

    @Override
    public boolean addEdge(V tail, V head)
    {
        //preconditions...
        /*if (!containsVertex(tail) || !containsVertex(head)) //missing vertex
        {
            return false;
        }
        //TODO I think this will be redudant to traverse the LL twice!
        else if (containsEdge(tail, head)) //edge already exists
        {
            return false;
        }*/

        //otherwise, enter the vertex
        if (adjLists.get(tail) == null) //is the adj list empty?
        {
            adjLists.put(tail, new Node(head));
        }
        else
        {
            //put a new node at the start of the adj list
            Node newNode = new Node(head);
            newNode.next = adjLists.get(tail);
            adjLists.put(tail, newNode);
        }
        return true;
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

    //Node class for our adjacency lists
    private class Node
    {
        private V vertex;
        private Node next;
        private int weight;

        public Node(V vertex)
        {
            this.vertex = vertex;
        }

        @Override
        public String toString()
        {
            return "Node (" + vertex.toString() + ")";
        }
    }
}
