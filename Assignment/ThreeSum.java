import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class ThreeSum {
    static int[][] threeSum(int[] nums) {
        Arrays.sort(nums);
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate first elements
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(new int[]{
                            nums[i],
                            nums[left],
                            nums[right]
                    });
                    left++;
                    right--;
                    // Skip duplicates
                    while (left < right &&
                            nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right &&
                            nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        int[][] answer = new int[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
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
        int[][] result = threeSum(nums);
        System.out.println("Triplets:");
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
        sc.close();
    }
}