import java.util.HashSet;
import java.util.Set;

class PairWithGivenSum {
    public static boolean findPair(int[] arr, int targetSum) {
        Set<Integer> seen = new HashSet<>();

        for (int num : arr) {
            if (seen.contains(targetSum - num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }
}

public class PairWithGivenSumm{
    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 7, 4, 9};
        int targetSum = 10;

        boolean result = PairWithGivenSum.findPair(arr, targetSum);

        if (result) {
            System.out.println("Pair with given sum found.");
        } else {
            System.out.println("No pair with given sum exists.");
        }
    }
}
