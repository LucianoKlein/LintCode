package easyLintcode._153CombinationSumII;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (num == null) {
            return result;
        }
        int length = num.length;
        if (length == 0) {
            return result;
        }
        
        quickSort(num, 0, length - 1);
        List<Integer> combination = new ArrayList<>();
        helper(num, 0, combination, target, result);
        
        return result;
        
    }
    
    
    private void helper(int[] candidates,
                        int startIndex,
                        List<Integer> combination,
                        int target,
                        List<List<Integer>> results) {
        if (target == 0) {
            results.add(new ArrayList<Integer>(combination));
            return;
        }
        
        for (int i = startIndex; i < candidates.length; i++) {
            if (i != startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (target < candidates[i]) {
                break;
            }
            
            combination.add(candidates[i]);
            helper(candidates, i + 1, combination, target - candidates[i], results);
            combination.remove(combination.size() - 1);
        }
        
    }
    
    private void quickSort(int[] num, int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        int pivot = num[(start + end) / 2];
        while (left <= right) {
            while (left <= right && num[left] < pivot) {
                left++;
            }
            
            while (left <= right && num[right] > pivot) {
                right--;
            }
            
            if (left <= right) {
                int temp = num[left];
                num[left] = num[right];
                num[right] = temp;
                
                left++;
                right--;
            }
        }
        quickSort(num, start, right);
        quickSort(num, left, end);
    }
    
    
}
