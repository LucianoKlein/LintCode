package easyLintcode._80Median;

public class Solution {
    /*
     * @param nums: A list of integers
     * @return: An integer denotes the middle number of the array
     */
    public int median(int[] nums) {
        // write your code here
        if (nums == null) {
            return -1;
        }
        
        int len = nums.length;
        if (len == 0) {
            return -1;
        }
        
        quickSort(nums, 0, nums.length - 1);
        
        return nums[len / 2];
    }
    
    public void quickSort(int[] nums, int start, int end) {
        //exit
        if (start >= end) {
            return;
        }
        
        int left = start;
        int right = end;
        
        int pivot = nums[(start + end) / 2];
        //disassemble
        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++; 
            }
            
            while (left <= right && nums[right] > pivot) {
                right--;
            }
            
            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                
                left++;
                right--;
            }
        }
        
        quickSort(nums, start, right);
        quickSort(nums, left, end);
        
    }
}
