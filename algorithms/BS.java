import java.util.Arrays;

public class BS {
    
    public int[] bubbleSort(int[] arr) {

        int temp = -1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j< arr.length -i - 1; j++) {

                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        BS b = new BS();
        int[] arr = {44, 55, 11, 33, 22}; 
        System.out.println(Arrays.toString(b.bubbleSort(arr)));
    }
}
