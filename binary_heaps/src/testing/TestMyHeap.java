package testing;

import queues.MinBinaryHeap;

import java.util.ArrayList;

public class TestMyHeap
{
    public static void main(String[] args)
    {
        MinBinaryHeap<Integer> heapOfInts = new MinBinaryHeap<>();
        heapOfInts.insert(-20, 44, 343, 42, 10, 11, 10, 100, 100, 100, 15, 30, 900, 14);
        System.out.println(heapOfInts);
    }
}
