package easyLintcode._80Median;

import java.util.Arrays;

import org.junit.Test;

public class Demo {
	@Test
	public void testing() {
		Solution s = new Solution();
		int[] nums = new int[] {7, 9, 4, 5};
		s.quickSort(nums, 0, nums.length - 1);
		System.out.println(Arrays.toString(nums));
	}
}
