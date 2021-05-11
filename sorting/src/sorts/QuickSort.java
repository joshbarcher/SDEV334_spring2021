package sorts;

import utility.Sorts;

import java.util.Arrays;

public class QuickSort
{
    public static void main(String[] args)
    {
        int[] array = Sorts.genArray(10);

        //unsorted
        System.out.println(Arrays.toString(array));
        System.out.println("Detected inversions: " +
                Sorts.detectAdjacentInversions(array));
        System.out.println();

        //sorted
        quickSort(array);
        System.out.println(Arrays.toString(array));
        System.out.println("Detected inversions: " +
                Sorts.detectAdjacentInversions(array));
    }

    //sorts our array
    public static void quickSort(int[] array)
    {
        quickSort(array, 0, array.length - 1);
    }

    //sorts a sub-array from low to high
    private static void quickSort(int[] array, int low, int high)
    {
        if (low >= high)
        {
            return;
        }

        //pick my pivot
        int pivot = array[low];

        //partition my data
        int i = low, j = high;
        while (i <= j)
        {
            //look for an element larger than the pivot
            while (array[i] < pivot)
            {
                i++;
            }

            //look for an element smaller than the pivot
            while (array[j] > pivot)
            {
                j--;
            }

            //if the pointers haven't "crossed" one another
            if (i <= j)
            {
                Sorts.swap(array, i, j);

                //move the pointers forward
                i++;
                j--;
            }
        }

        //recursively sort the left and right sub-array
        if (low < j)
        {
            quickSort(array, low, j);
        }

        if (high > i)
        {
            quickSort(array, i, high);
        }
    }
}
