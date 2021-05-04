package sorts;

public class MergeSort
{
    private static int[] aux;

    public static void main(String[] args)
    {

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
        if (high - low <= 0)
        {
            return;
        }

        int mid = (high + low) / 2;
        mergeSort(array, low, mid);
        mergeSort(array, mid + 1, high);

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
            if (left > mid)
            {
                aux[i] = array[right++];
            }
            else if (right > high)
            {
                aux[i] = array[left++];
            }
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
