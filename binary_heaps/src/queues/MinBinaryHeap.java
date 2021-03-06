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

    public MinBinaryHeap(T[] elementsToInsert)
    {
        //insert all elements in the input array
        arrayTree = (T[]) new Comparable[elementsToInsert.length + 1]; //make room for unoccupied index zero

        //copy over the elements
        for (int i = 0; i < elementsToInsert.length; i++)
        {
            //careful to skip index zero... (i + 1)
            arrayTree[i + 1] = elementsToInsert[i];
        }

        //change our size/next index variable
        nextUnusedIndex = elementsToInsert.length;

        //heapify!
        for (int i = size() / 2; i >= 1; i--)
        {
            sink(i);
        }
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
        checkForEmptyHeap();

        //save my return value
        T result = arrayTree[1];

        //reorder the heap
        arrayTree[1] = arrayTree[nextUnusedIndex - 1];
        arrayTree[nextUnusedIndex - 1] = null;
        nextUnusedIndex--;

        sink(1);

        return result;
    }

    private void sink(int parentIndex)
    {
        //loop as long as the index has a child (the last child is at index size() / 2)
        while (parentIndex <= size() / 2)
        {
            int leftIndex = 2 * parentIndex;
            int rightIndex = 2 * parentIndex + 1;

            //determine which child is smaller?
            int smallestIndex = leftIndex;
            if (rightIndex < nextUnusedIndex && arrayTree[rightIndex].compareTo(arrayTree[leftIndex]) < 0)
            {
                smallestIndex = rightIndex;
            }

            //then compare the smallest child with the current node
            if (arrayTree[parentIndex].compareTo(arrayTree[smallestIndex]) > 0)
            {
                //swap, they are out of order...
                swap(parentIndex, smallestIndex);

                //move to that child
                parentIndex = smallestIndex;
            }
            else
            {
                //exit loop, we have reordered the heap (short-circuit)
                break;
            }
        }
    }

    private void checkForEmptyHeap()
    {
        //empty heap?
        if (isEmpty())
        {
            throw new IllegalStateException("The heap is empty");
        }
    }

    @Override
    public T peek()
    {
        checkForEmptyHeap();

        return null;
    }

    @Override
    public int size()
    {
        return nextUnusedIndex - 1;
    }

    @Override
    public boolean isEmpty()
    {
        return size() == 0;
    }

    @Override
    public boolean contains()
    {
        return false;
    }
}
