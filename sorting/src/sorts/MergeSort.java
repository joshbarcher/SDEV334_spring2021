package sorts;

import utility.Sorts;

import java.util.Arrays;
import java.util.Random;

public class MergeSort
{
    private static int[] aux;

    public static void main(String[] args)
    {
        int[] array = Sorts.genArray(10);

        //unsorted
        System.out.println(Arrays.toString(array));
        System.out.println("Detected inversions: " +
                Sorts.detectAdjacentInversions(array));
        System.out.println();

        //sorted
        mergeSort(array);
        System.out.println(Arrays.toString(array));
        System.out.println("Detected inversions: " +
                Sorts.detectAdjacentInversions(array));
    }

    public static void mergeSort(int[] array)
    {
        //precondition
        if (array.length <= 1)
        {
            return;
        }

        aux = new int[array.length];
        mergeSort(array, 0, array.length - 1);
    }

    private static void mergeSort(int[] array, int low, int high)
    {
        //there are no elements between low and high
        if (high - low <= 0)
        {
            return;
        }

        //otherwise, find the mid point and recusively divide our array
        int mid = (high + low) / 2;
        mergeSort(array, low, mid);
        mergeSort(array, mid + 1, high);

        //after we have sorted the left and right sub-array, then merge them
        merge(array, low, high);
    }

    private static void merge(int[] array, int low, int high)
    {
        int mid = (high + low) / 2;
        int left = low;
        int right = mid + 1;
        int numToMerge = high - low + 1;

        for (int i = 0; i < numToMerge; i++)
        {
            //have I exhausted all elements in the left or right sub-array?
            if (left > mid)
            {
                aux[i] = array[right++];
            }
            else if (right > high)
            {
                aux[i] = array[left++];
            }
            //pick the smallest element
            else if (array[left] < array[right])
            {
                aux[i] = array[left++];
            }
            else //if (array[right] <= array[left])
            {
                aux[i] = array[right++];
            }
        }

        //copy our merged sub-arrays from the aux array back to the original
        for (int i = 0; i < numToMerge; i++)
        {
            array[low + i] =  aux[i];
        }
    }
}
