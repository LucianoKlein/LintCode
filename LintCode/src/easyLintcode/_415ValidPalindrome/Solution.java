package easyLintcode._415ValidPalindrome;

public class Solution {
    /*
     * @param s: A string
     * @return: Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // write your code here
        if (s == null || s.isEmpty()) {
            return true;
        }
        int length = s.length();
        int j = length - 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if ((s.charAt(i) > 'A' && s.charAt(i) < 'z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                sb.append(s.charAt(i));
            }
        }
        String afterProcessing = sb.toString().toLowerCase();
        length = afterProcessing.length();
        
        int i = 0;
        j = length - 1;
        while (i < length && j >= 0) {
            if (afterProcessing.charAt(i) != afterProcessing.charAt(j)) {
                break;
            }
            i++;
            j--;
        }
        
        if (i == length && j == -1) {
            return true;
        }
        
        
        return false;
        
    }
}
