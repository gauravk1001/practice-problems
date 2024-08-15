package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CombinationSum {

/*     public void split (int [] ar) {

        List<Integer> arl = new ArrayList<>(); 

        for (int i = 0; i < ar.length; i++) {
            arl.add(ar[i]);
        }

        for (int i = 0; i < arl.size(); i++) {
            ArrayList<Integer> copy = new ArrayList<>(arl);
            int x = copy.remove(i);

            int sum = x;
            findCombination(x, copy, sum);
        }
    }
    
*/

    public void findCombination (int start, ArrayList<Integer> arr, ArrayList<Integer> curCombo, int target, int curSum) {


        if (target == curSum) {
            System.out.println(curCombo);
            return;
        }

        for (int i = 1; i < arr.size(); i++) {

            if (curSum + arr.get(i) > target) {
                continue;
            }

            if (i > start && (arr.get(i) == arr.get(i - 1))) {
                continue;
            }

            curCombo.add(arr.get(i));

            findCombination(i + 1, arr, curCombo, target, curSum + arr.get(i));

            curCombo.remove(curCombo.size() - 1);
        }
    }


    public static void main (String ar[]) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(10);
        arr.add(1);
        arr.add(2);
        arr.add(7);
        arr.add(6);
        arr.add(1);
        arr.add(5);
        arr.add(18);

        int tar = 8;

        CombinationSum cs = new CombinationSum();

        Collections.sort(arr);
        System.out.println("sorted= " + arr);

        cs.findCombination(0, arr, new ArrayList<Integer>(), tar, 0);
 
    }
}
