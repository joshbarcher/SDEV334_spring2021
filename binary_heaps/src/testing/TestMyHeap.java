package testing;

import queues.MinBinaryHeap;

import java.util.ArrayList;

public class TestMyHeap
{
    public static void main(String[] args)
    {
        MinBinaryHeap<Integer> heapOfInts = new MinBinaryHeap<>();
        heapOfInts.insert(11, 15, 19, 19, 17, 22);
        System.out.println(heapOfInts);

        //remove all elements one-by-one
        while (!heapOfInts.isEmpty())
        {
            System.out.println(heapOfInts.remove());
        }
    }
}
