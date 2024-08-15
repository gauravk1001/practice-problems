import java.util.*;
// Add any extra import statements you may need here

class ElementSwapping {

  // Add any helper functions you may need here

  int[] findMinArray(int[] arr, int k) {
    // Write your code here

    int swaps = 0;

    for (int i = 0; i < arr.length; i++) {
      // getting the smallest jump down index out of the current array which is within
      // reach of swaps
      int jdIndex = findJumpDownIndex(arr, i, i + k - swaps);
      if (jdIndex == -1) {
        continue;
      }

      // check how much you can move it to left
      // no

      // bring it to left as much as possible. swaps < k
      for (int j = jdIndex; j > i; j--) {
        if (arr[j - 1] > arr[j] && swaps < k) {
          arr = swap(arr, j - 1, j);
          swaps++;
        }
        System.out.println("swapped " + arr[j - 1] + " and " + arr[j] + " arr=" + Arrays.toString(arr));
      }

      if (swaps >= k) {
        return arr;
      }
    }

    return arr;

  }

  private int findJumpDownIndex(int[] arr, int left, int right) {
    int jdIndex = -1;
    System.out.println("find jd index called with=" + Arrays.toString(arr) + " " + left + ", " + right);

    for (int k = left + 1; k <= right && k < arr.length; k++) {
      if (arr[k] < arr[k - 1]) {
        jdIndex = k;
      }
    }
    System.out.println("jdindex=" + jdIndex);
    return jdIndex;
  }

  private int[] swap(int[] arr, int x, int y) {
    int temp = arr[x];
    arr[x] = arr[y];
    arr[y] = temp;

    return arr;
  }

  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom.
  int test_case_number = 1;

  void check(int[] expected, int[] output) {
    int expected_size = expected.length;
    int output_size = output.length;
    boolean result = true;
    if (expected_size != output_size) {
      result = false;
    }
    for (int i = 0; i < Math.min(expected_size, output_size); i++) {
      result &= (output[i] == expected[i]);
    }
    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);
    } else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      printIntegerArray(expected);
      System.out.print(" Your output: ");
      printIntegerArray(output);
      System.out.println();
    }
    test_case_number++;
  }

  void printIntegerArray(int[] arr) {
    int len = arr.length;
    System.out.print("[");
    for (int i = 0; i < len; i++) {
      if (i != 0) {
        System.out.print(", ");
      }
      System.out.print(arr[i]);
    }
    System.out.print("]");
  }

  public void run() {
    int n_1 = 3, k_1 = 2;
    int[] arr_1 = { 5, 3, 1 };
    int[] expected_1 = { 1, 5, 3 };
    int[] output_1 = findMinArray(arr_1, k_1);
    check(expected_1, output_1);

    int n_2 = 5, k_2 = 3;
    int[] arr_2 = { 8, 9, 11, 2, 1 };
    int[] expected_2 = { 2, 8, 9, 11, 1 };
    int[] output_2 = findMinArray(arr_2, k_2);
    check(expected_2, output_2);

    // Add your own test cases here

  }

  public static void main(String[] args) {
    new ElementSwapping().run();
  }
}