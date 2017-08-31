package easyLintcode._604WindowSum;

public class Solution {
    /*
     * @param nums: a list of integers.
     * @param k: length of window.
     * @return: the sum of the element inside the window at each moving.
     */
    public int[] winSum(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length < k || k == 0) {
            return new int[0];
        }
        int[] prefixSum = new int[nums.length + 1];
        int tempSum = 0;
        for (int i = 0; i < nums.length; i++) {
            tempSum += nums[i];
            prefixSum[i + 1] = tempSum;
        }
        int resLength = nums.length - k + 1;
        
        int[] result = new int[resLength];
        
        for (int i = 0; i < nums.length; i++) {
            if (i >= k - 1) {
                result[i - k + 1] = prefixSum[i + 1] - prefixSum[i + 1 - k];
            }
        }
        return result;
    }
}
