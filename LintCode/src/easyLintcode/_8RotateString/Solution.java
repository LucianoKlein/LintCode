package easyLintcode._8RotateString;

import java.util.Arrays;

public class Solution {
    /*
     * @param str: An array of char
     * @param offset: An integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        if (str == null || str.length == 0) {
            return;
        }
        
        int length = str.length;
        offset %= str.length;
        
        
        switcher(str, 0, length - 1 - offset);
        
        switcher(str, length - offset, length - 1);
        
        switcher(str, 0, length - 1);
        
    }
    
    private void switcher (char[] str, int from, int to) {
        if (from >= to) {
            return;
        }
        char temp;
        while (from < to) {
            temp = str[from];
            str[from] = str[to];
            str[to] = temp;
            from ++;
            to --;
        }
        
    }
}
