import java.util.Arrays;

class QuickSort {

    public void quickSort(int [] arr, int left, int right) {
        int index = partition(arr, left, right);

        if (left < index - 1 ) {
            quickSort(arr, left, index - 1);
        }
        if (index < right) {
            quickSort(arr, index, right);
        }
    }

    public int partition(int [] arr, int left, int right) {
        // choose pivot
        int pivot = arr[left + (right - left) / 2];

        while (left <= right) {
            // Find element on the left that should be on right
            while (arr[left] < pivot) {
                left++;
            }
            // Find element on the right that should be on left
            while (arr[right] > pivot) {
                right--;
            }

            // Swap elements and move left and right indices for next iteration
            if (left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }

        return left;
    }

    public void swap(int [] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }

    public static void main(String[] args) {
        QuickSort q = new QuickSort();
        int [] arr = {5, 8, 15, 4, 1, 6, 10};
        q.quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}   