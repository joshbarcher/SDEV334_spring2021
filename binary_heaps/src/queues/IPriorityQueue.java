package queues;

public interface IPriorityQueue<T extends Comparable<T>>
{
    //primary priority queue ADT methods
    T remove();
    T peek();
    void insert(T... element);

    //other methods...
    int size();
    boolean isEmpty();
    boolean contains();
}
