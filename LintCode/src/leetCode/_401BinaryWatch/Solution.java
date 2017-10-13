package leetCode._401BinaryWatch;

import java.util.ArrayList;
import java.util.List;

class Solution {
    
    int numOfLed = 0;
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        if (num < 0) {
            return res;
        }
        
        if (num == 0) {
            res.add("0:00");
            return res;
        }
        List<List<Integer>> indexesList = new ArrayList<>();
        
        
        int[] watch = {8, 4, 2, 1, 32, 16, 8, 4, 2, 1};
        numOfLed = num;
        int upperBound = 9 - 0 + 0 - 1;
        
        List<Integer> indexes = new ArrayList<>();
        
        for (int i = 0; i < upperBound; i++) {
            dfs(i, indexesList, 1, indexes);
        }
        System.out.println(indexesList);
        
        int hour = 0;
        int minute = 0;
        String spliter = new String(":");
        for (List<Integer> index : indexesList) {
            for (Integer k : index) {
                if (k < 4) {
                    hour += watch[k];
                }
                
                if (k > 4) {
                    minute += watch[k];
                }
            }
            
            if (hour > 11 || minute > 59) {
                if (!(hour == 12 && minute == 0)) {
                    continue;
                }
            }
            if (minute == 0) {
                res.add(new String(hour + spliter + "00"));
            }
            res.add(new String(hour + spliter + minute));
        }
        
        return res;
        
    }
    
    public void dfs(int val, List<List<Integer>> indexesList, int depth, List<Integer> indexes) {
        
        if (depth == numOfLed) {
            indexes.add(val);
            indexesList.add(new ArrayList<>(indexes));
            indexes.remove(indexes.size() - 1);
            return;
        }
        
        int numOfLeaves = 9 - val + depth - 2;
        
        for (int i = val + 1; i <= numOfLeaves; i++) {
        	indexes.add(i);
            dfs(i, indexesList, depth + 1, indexes);
            indexes.remove(indexes.size() - 1);
        }
        
        return;
    }
}