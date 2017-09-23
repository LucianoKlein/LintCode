package easyLintcode._547IntersectionOfTwoArrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    
    /*
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return: an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        int length1 = nums1.length;
        int length2 = nums2.length;
        
        Map<Integer, Boolean> map = new HashMap<>();
        
        
        for (int i = 0; i < length1; i++) {
            map.put(nums1[i], false);
        }
        
        for (int i = 0; i < length2; i++) {
            if (map.containsKey(nums2[i])) {
                map.put(nums2[i], true);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (Integer i : map.keySet()) {
            if (map.get(i) == true) {
                res.add(i);
            }
        }
        
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}
