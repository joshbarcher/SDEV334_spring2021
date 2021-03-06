package structures;

import adts.IDirectedGraph;
import adts.IWeightedGraph;

import java.util.*;

/**
 * This is a graph that is directed and weighted. The graph
 * is based on adjacency lists.
 *
 * @param <V>
 */
public class MyGraph<V> implements IDirectedGraph<V>, IWeightedGraph<V>
{
    private Map<V, Node> adjLists;
    private int vertexSize;
    private int edgeSize;

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
        vertexSize++;
        return true;
    }

    @Override
    public boolean addEdge(V tail, V head)
    {
        //preconditions...
        if (!containsVertex(tail) || !containsVertex(head)) //missing vertex
        {
            return false;
        }
        else if (containsEdge(tail, head)) //edge already exists
        {
            return false;
        }

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
        edgeSize++;
        return true;
    }

    @Override
    public boolean containsVertex(V search)
    {
        return adjLists.containsKey(search);
    }

    @Override
    public boolean containsEdge(V tail, V head)
    {
        if (!adjLists.containsKey(tail))
        {
            return false;
        }

        Node list = adjLists.get(tail);
        while (list != null)
        {
            if (list.vertex.equals(head))
            {
                return true;
            }
            list = list.next;
        }
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
        adjLists.clear();
        vertexSize = 0;
        edgeSize = 0;
    }

    @Override
    public int vertexSize()
    {
        return vertexSize;
    }

    @Override
    public int edgeSize()
    {
        return edgeSize;
    }

    @Override
    public boolean isVertexSetEmpty()
    {
        return vertexSize == 0;
    }

    @Override
    public boolean isEdgeSetEmpty()
    {
        return edgeSize == 0;
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
    public List<V> dfs(V source)
    {
        return null;
    }

    public Map<V, V> bfsWithMaps(V start)
    {
        Set<V> seen = new HashSet<>();
        Map<V, V> traversal = new HashMap<>();
        Queue<V> bfsQueue = new LinkedList<>();

        //add the first element
        bfsQueue.add(start);
        traversal.put(start, null);

        while (!bfsQueue.isEmpty())
        {
            V nextElement = bfsQueue.poll();
            seen.add(nextElement);

            //add adjacent vertices
            //add adjacent vertices if not visited yet
            Node node = adjLists.get(nextElement);
            while (node != null)
            {
                if (!seen.contains(node.vertex))
                {
                    traversal.put(node.vertex, nextElement);
                    bfsQueue.add(node.vertex);
                }
                node = node.next;
            }
        }

        return traversal;
    }

    @Override
    public List<V> bfs(V source)
    {
        //supplemental structures
        Set<V> seen = new HashSet<>();
        List<V> traversal = new ArrayList<>();
        Queue<V> queue = new LinkedList<>();

        //add the source and loop
        queue.add(source);
        while (!queue.isEmpty())
        {
            //visit the next vertex
            V removed = queue.remove();
            if (!seen.contains(removed))
            {
                seen.add(removed);
                traversal.add(removed);

                //add adjacent vertices if not visited yet
                Node node = adjLists.get(removed);
                while (node != null)
                {
                    if (!seen.contains(node.vertex))
                    {
                        queue.add(node.vertex);
                    }
                    node = node.next;
                }
            }
        }
        return traversal;
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

    @Override
    public String toString()
    {
        //this builder will help us assemble a string without unnecessary string objects being created
        StringBuilder builder = new StringBuilder();

        //print a visualization of the graph
        for (V key : adjLists.keySet())
        {
            //print the vertex (key)
            builder.append(key).append(": ");

            //print the elements in the adjacency list
            Node list = adjLists.get(key);
            while (list != null)
            {
                builder.append(list.vertex).append(" -> ");
                list = list.next;
            }
            builder.append("\n");
        }

        return builder.toString();
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
