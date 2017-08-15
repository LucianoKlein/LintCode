package _strStrII;

public class Solution {
    /**
     * @param source a source string
     * @param target a target string
     * @return an integer as index
     */
    private final int BASE = 33;
    private final int MOD = 1000000;
    public int strStr2(String source, String target) {
        if (target == null) {
            return -1;
        }
        int targetLength = target.length();
        
        if (targetLength == 0 && source != null) {
            return 0;
        }
        
        if (source == null) {
            return -1;
        }
        int sourceLength = source.length();
        if (sourceLength == 0) {
            return -1;
        }
        
        int hashTarget = hashCode(target, BASE);
        int weightOfLeft = 1;
        
        for (int i = 0; i < targetLength - 1; i++) {
            weightOfLeft = weightOfLeft * BASE % MOD;
        }
        int hashSource = 0;
        for (int i = 0; i < sourceLength; i++) {
            if (i >= targetLength) {
                hashSource = (hashSource - weightOfLeft * (source.charAt(i - targetLength) - 'a')) % MOD;
                if (hashSource < 0) {
                    hashSource += MOD;
                }
            }
            
            hashSource = (hashSource * BASE + (source.charAt(i) - 'a')) % MOD;
            if (hashSource < 0) {
                hashSource += MOD;
            }
            
            if (i >= targetLength - 1 && hashTarget == hashSource) {
                if(target.equals(source.substring(i - targetLength + 1, i + 1))) {
                    return i - targetLength + 1;
                }
            }
            
        }
        return -1;
    }
    
    private int hashCode(String s, int base) {
        int sLength = s.length();
        int result = 0;
        for (int i = 0; i < sLength; i++) {
            result = (result * BASE + s.charAt(i) - 'a') % MOD;
            if (result < 0) {
                result += MOD;
            }
        }
        return result;
    }
}
