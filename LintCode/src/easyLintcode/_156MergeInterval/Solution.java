package easyLintcode._156MergeInterval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
class Interval {
	int start, end;
	Interval(int start, int end) {
		this.start = start;
		this.end = end;
    }
}

public class Solution {
	public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        List<Interval> ans = new ArrayList<>();
        intervals.sort(Comparator.comparing(i -> i.start));  //lambda 匿名函数：输入i  返回i.start
        Interval last = null;
        for (Interval item : intervals) {
            if (last == null || last.end < item.start) {
                ans.add(item);
                last = item;
            } else {
                last.end = Math.max(last.end, item.end); // Modify the element already in list
            }
        }
        return ans;
    }
}
