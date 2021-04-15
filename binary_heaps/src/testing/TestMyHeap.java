package testing;

import movies.FavoriteMovie;
import queues.MinBinaryHeap;

import java.util.ArrayList;

public class TestMyHeap
{
    public static void main(String[] args)
    {
        FavoriteMovie[] movies = {
            new FavoriteMovie(3, "Sharknado"),
            new FavoriteMovie(5, "Lord of the Rings (Trilogy)"),
            new FavoriteMovie(5, "Tropic Thunder"),
            new FavoriteMovie(4, "Braveheart"),
            new FavoriteMovie(5, "IT"),
            new FavoriteMovie(2, "Flubber"),
            new FavoriteMovie(3, "Rubber"),
            new FavoriteMovie(1, "Scream"),
            new FavoriteMovie(5, "Dark Knight"),
            new FavoriteMovie(4, "Tron Legacy")
        };

        //use the heapify or build-heap routine
        MinBinaryHeap<FavoriteMovie> moviesHeap = new MinBinaryHeap<>(movies);

        //favorite or least favorite?
        System.out.println(moviesHeap.remove());

        while (!moviesHeap.isEmpty())
        {
            System.out.println(moviesHeap.remove());
        }
    }

    private static void exampleWithInts()
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
