package BasicLesson.ladder4_bfs._120WordLadder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if (dict == null) {
            return 0;
        }
        
        if (start.equals(end)) {
            return 1;
        }
        
        dict.add(start);
        dict.add(end);
        
        HashSet<String> hash = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        
        queue.offer(start);
        hash.add(start);
        
        int length = 1;
        
        while (!queue.isEmpty()) {
            length++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (String nextWord : getNextWords(word, dict)) {
                    if (hash.contains(nextWord)) {
                        continue;
                    }   
                    if (nextWord.equals(end)) {
                        return length;
                    }
                    
                    hash.add(nextWord);
                    queue.offer(nextWord);
                }
            }
        }
        
        return 0;
    }
    /**
     * 
     * 
     */
    
    private ArrayList<String> getNextWords(String word, Set<String> dict) {
        //结果集记录返回的结果
        ArrayList<String> nextWords = new ArrayList<String>();
        //从a到z
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                String nextWord = replace(word, i, c);
                if (dict.contains(nextWord)) {
                    nextWords.add(nextWord);
                }
            }
        }
        return nextWords;
    }
    //把index个字符, 替换成c
    private String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
}
