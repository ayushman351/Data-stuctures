import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ZeroSumSubarrays {

    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        List<int[]> result = new ArrayList<>();
        int sum = 0;

        // Handle subarrays starting from index 0
        sumMap.put(0, new ArrayList<>(Arrays.asList(-1)));

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sumMap.containsKey(sum)) {
                for (int startIndex : sumMap.get(sum)) {
                    result.add(new int[]{startIndex + 1, i});
                }
            }

            sumMap.computeIfAbsent(sum, k -> new ArrayList<>()).add(i);
        }
        return result;
    }
}

public class ZeroSumSubArrays {
    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 1, 2, -1, 6, -6};
        List<int[]> result = ZeroSumSubarrays.findZeroSumSubarrays(arr);

        if (result.isEmpty()) {
            System.out.println("No subarrays with zero sum found.");
        } else {
            System.out.println("Zero Sum Subarrays are:");
            for (int[] range : result) {
                System.out.println("From index " + range[0] + " to index " + range[1]);
            }
        }
    }
}
