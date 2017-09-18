package easyLintcode._452RemoveDuplicateNumbers;

public class Solution {
    /*
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
    public int deduplication(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        quickSort(nums, 0, nums.length - 1);
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[len]) {
                //必须要先++
                nums[++len] = nums[i];
            }
        }
        return len + 1;
    }
    
    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        
        int left = start, right = end;
        //首先, pivot是值, 而不是索引
        int pivot = nums[(start + end) / 2];
        
        //其次, 每次你比较左和右的时候
        //left <= right
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
