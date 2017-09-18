package easyLintcode._8RecoverRotatedSortedArray;

import java.util.List;

public class Solution {
    /*
     * @param nums: An integer array
     * @return: nothing
     */
    public void recoverRotatedSortedArray(List<Integer> nums) {
        int offset = binarySearch(nums);
        int length = nums.size();
        swap(nums, 0, offset - 1);
        swap(nums, offset, length - 1);
        swap(nums, 0, length - 1);
        
    }
    
    public int binarySearch(List<Integer> nums) {
        int start = 0;
        int end = nums.size() - 1;
        int mid;
        
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums.get(mid) > nums.get(mid + 1)) {
                return mid + 1;
            } else {
                if (nums.get(mid) > nums.get(end)) {
                    start = mid;
                }
                if (nums.get(mid) <= nums.get(end)) {
                    end = mid;
                }
            }
        }
        
        if (nums.get(start) < nums.get(end)) {
            return start;
        } else {
            return end;
        }
    }
    
    public void swap(List<Integer> nums, int start, int end) {
        int temp;
        while (start < end) {
            temp = nums.get(start);
            nums.set(start, nums.get(end));
            nums.set(end, temp);
            start++;
            end--;
        }
    }
}
