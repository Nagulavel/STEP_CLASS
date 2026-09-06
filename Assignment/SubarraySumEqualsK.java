import java.util.HashMap;
import java.util.Scanner;
public class SubarraySumEqualsK {
    static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixSumFrequency =
                new HashMap<>();
        // Empty prefix
        prefixSumFrequency.put(0, 1);
        int currentSum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            int requiredSum = currentSum - k;
            if (prefixSumFrequency.containsKey(requiredSum)) {
                count += prefixSumFrequency.get(requiredSum);
            }
            if (prefixSumFrequency.containsKey(currentSum)) {
                prefixSumFrequency.put(
                        currentSum,
                        prefixSumFrequency.get(currentSum) + 1
                );
            } else {
                prefixSumFrequency.put(currentSum, 1);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.print("Enter k: ");
        int k = sc.nextInt();
        int result = subarraySum(nums, k);
        System.out.println("Number of Subarrays: " + result);
        sc.close();
    }
}