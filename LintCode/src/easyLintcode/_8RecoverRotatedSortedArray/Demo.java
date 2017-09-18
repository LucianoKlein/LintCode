package easyLintcode._8RecoverRotatedSortedArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class Demo {
	@Test
	public void testing() {
		Solution s = new Solution();
		List<Integer> list = Arrays.asList(new Integer[]{1, 1, 1, 1, 1, 1, 1, 1, 1, -1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1});
		System.out.println(s.binarySearch(list));
		s.recoverRotatedSortedArray(list);
		System.out.println(list);
	}
}
