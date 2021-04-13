package queues;

public class MinBinaryHeap<T extends Comparable<T>> implements IPriorityQueue<T>
{
    private static final int INITIAL_TREE_SIZE = 10;
    private static final int RESIZE_FACTOR = 2;

    private T[] arrayTree;
    private int nextUnusedIndex = 1;

    public MinBinaryHeap()
    {
        arrayTree = (T[]) new Comparable[INITIAL_TREE_SIZE];
    }

    private void insert(T element)
    {
        //if we run out of room
        if (nextUnusedIndex == arrayTree.length)
        {
            resize();
        }

        //place the element in the tree
        arrayTree[nextUnusedIndex] = element;

        //reorder the tree
        swim(nextUnusedIndex);

        //prepare for our next insertion
        nextUnusedIndex++;
    }

    @Override
    public void insert(T... elements)
    {
        for (int i = 0; i < elements.length; i++)
        {
            insert(elements[i]);
        }
    }

    private void swim(int child)
    {
        //loop from the current index to all ancestor nodes in the tree,
        //comparing child to parent and swapping if out of order

        //as long as the current index has parent
        while (child > 1)
        {
            int parent = child / 2;

            //is the parent element larger, if so swap them
            if (arrayTree[parent].compareTo(arrayTree[child]) > 0)
            {
                swap(parent, child);
            }
            else //if they are in order, then short-circuit
            {
                break;
            }

            //move the index up the tree
            child = parent;
        }
    }

    private void swap(int parent, int child)
    {
        T temp = arrayTree[parent];
        arrayTree[parent] = arrayTree[child];
        arrayTree[child] = temp;
    }

    private void resize()
    {
        T[] newArrayTree = (T[]) new Comparable[arrayTree.length * RESIZE_FACTOR];

        for (int i = 0; i < arrayTree.length; i++)
        {
            newArrayTree[i] = arrayTree[i];
        }

        //replace the old tree
        arrayTree = newArrayTree;
    }

    @Override
    public T remove()
    {
        return null;
    }

    @Override
    public T peek()
    {
        return null;
    }

    @Override
    public int size()
    {
        return 0;
    }

    @Override
    public boolean isEmpty()
    {
        return false;
    }

    @Override
    public boolean contains()
    {
        return false;
    }
}
