import java.util.Arrays;

public class ArrayIntervals {

    public String getSum(int[] arr1) {

        int ptr1 = arr1.length - 1;
        int ptr2 = arr2.length - 1;
        int sumLength = arr1.length > arr2.length ? arr1.length + 1 : arr2.length + 1;
        int[] sum = new int[sumLength];
        int ptr3 = sumLength - 1;

        int carry = 0;
        int temp;

        for (;ptr1 >=0 || ptr2 >= 0 || ptr3 >= 0; ptr1--, ptr2--, ptr3--) {

            if (ptr1 < 0 && ptr2 < 0) {
                temp = carry;
            } else if (ptr1 < 0) {
                temp = arr2[ptr2] + carry;
            } else if (ptr2 < 0) {
                temp = arr1[ptr1] + carry;
            } else {
                temp = arr1[ptr1] + arr2[ptr2] + carry;
            }

            if (temp >= 10) {
                sum[ptr3] = temp % 10;
                carry = 1;
            } else {
                sum[ptr3] = temp;
                carry = 0;
            }
        }

        return "";
    }

    public static void main(String[] args) {
        //int[] arr1 = {1,1,5};
        //int[] arr2 = {1,1,5};

        int[] arr1 = {2, 4, 7, 15, 33, 84};

        System.out.println(new ArrayIntervals().getSum(arr1));
    }
}