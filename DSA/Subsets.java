import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Subsets {
    ///when array has duplicate values;
    //sort the array
    //then with duplicate arr
    //only add it to the
    public static List<List<Integer>> subsetsofarrDuplicate(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int strt = 0;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            strt = 0;
            if (i > 0 && nums[i] == nums[i - 1])
                strt = end + 1;
            end = outer.size() - 1;
            int n = outer.size();
            for (int j = strt; j < n; j++) {
                ArrayList<Integer> inner = new ArrayList<>(outer.get(j));
                inner.add(nums[i]);
                outer.add(inner);
            }
        }
        return outer;

    }

    //when array has no duplicate value;
    public static List<List<Integer>> subsetsofarr(int[] nums) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for (int x : nums) {
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(x);
                outer.add(inner);
            }
        }
        return outer;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
       // int n=sc.nextInt();

        int[] arr = {1, 2, 3, 4};//arr with no duplicate elements
        int[] arr1 = {1, 2, 2}; // array with duplicate elements
        List<List<Integer>> nlist = subsetsofarr(arr);
        System.out.println(nlist);
        List<List<Integer>> nlist1 = subsetsofarrDuplicate(arr1);
        System.out.println(nlist1);

    }

}