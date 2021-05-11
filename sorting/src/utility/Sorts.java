package utility;

public class Sorts
{
    public static boolean detectAdjacentInversions(int[] array)
    {
        //check whether any two adjacent elements are out of order
        for (int i = 0; i < array.length - 1; i++)
        {
            if (array[i] > array[i + 1])
            {
                return true;
            }
        }
        return false; //non were found, the array is sorted!
    }

    public static int[] genArray(int size)
    {
        int[] results = new int[size];

        //put random numbers in the array
        for (int i = 0; i < results.length; i++)
        {
            results[i] = (int)Math.ceil(Math.random() * size);
        }

        return results;
    }

    public static void swap(int[] array, int first, int second)
    {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
