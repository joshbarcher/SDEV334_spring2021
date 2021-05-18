package structures;

public class Edge<V>
{
    private V tail;
    private V head;
    private int weight;

    public Edge(V tail, V head, int weight)
    {
        this.tail = tail;
        this.head = head;
        this.weight = weight;
    }

    public V getTail()
    {
        return tail;
    }

    public void setTail(V tail)
    {
        this.tail = tail;
    }

    public V getHead()
    {
        return head;
    }

    public void setHead(V head)
    {
        this.head = head;
    }

    public int getWeight()
    {
        return weight;
    }

    public void setWeight(int weight)
    {
        this.weight = weight;
    }

    @Override
    public String toString()
    {
        return "Edge{" +
                "tail=" + tail +
                ", head=" + head +
                ", weight=" + weight +
                '}';
    }
}
