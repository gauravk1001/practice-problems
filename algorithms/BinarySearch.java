public class BinarySearch {

    public int search(int[] arr, int x, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = start + ((end - start) / 2);
        if (arr[mid] == x) {
            System.out.println("Found x=" + arr[mid] + " at index " + mid);
            return x;
        } else if (x <= arr[mid]) {
            System.out.println("Going left since " + x + " is less than " + arr[mid] + " at index " + mid);
            return search(arr, x, start, mid - 1);
        } else if (x > arr[mid]) {
            System.out.println("Going right since " + x + " is greater than " + arr[mid] + " at index " + mid);
            return search(arr, x, mid + 1, end);
        }

        return -1;
    }

    public static void main(String args[]) {
        BinarySearch bs = new BinarySearch();

        System.out.print(bs.search(new int[] { 1, 5, 7, 9, 15, 30, 45, 46, 70, 90, 100 }, 90, 0, 10));
    }
}
