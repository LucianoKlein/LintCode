package uberPhoneScreen.I._647SubstringAnagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    /**
     * @param s a string
     * @param p a non-empty string
     * @return a list of index
     */
    public List<Integer> findAnagrams(String s, String p) {
        // Write your code here
        int targetHash = hashInt(p);
        int sourceHash = 0;
        List<Integer> result = new ArrayList<>();
        if (s.isEmpty() || s.length() < p.length()) {
            return result;
        }
        
        
        for (int i = 0; i < s.length(); i++) {
            sourceHash += s.charAt(i);
            if (i >= p.length()) {
                sourceHash -= s.charAt(i - p.length());
            }
            if (i >= p.length() - 1) {
                if (sourceHash == targetHash) {
                    int currIndex = i - p.length() + 1;
                    if(isAnagram(s.substring(currIndex, i + 1), p)) {
                        result.add(currIndex);
                    }
                }
            }
        }
        return result;
    }
    
    private int hashInt(String p) {
        int sum = 0;
        for (int i = 0; i < p.length(); i++) {
            sum += p.charAt(i);
        }
        return sum;
    }
    
    private boolean isAnagram(String source, String target) {
        Map<Character, Integer> sourceMap = new HashMap<>(source.length() * 10);
        for (int i = 0; i < source.length(); i++) {
        	int currCharTimes = 1 + sourceMap.getOrDefault(source.charAt(i), 0);
        	sourceMap.put(source.charAt(i), currCharTimes);
        }
        for (int i = 0; i < target.length(); i++) {
            char currTarget = target.charAt(i);
        	if (!sourceMap.containsKey(currTarget)) {
                return false;
            }
            int currTargetTimes = sourceMap.get(currTarget) - 1;
            sourceMap.put(currTarget, currTargetTimes);
        }
        for (Integer i : sourceMap.values()) {
        	if (i != 0) {
        		return false;
        	}
        }
        return true;
        
    }
}
