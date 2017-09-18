package easyLintcode._8RotateString;

import java.util.Arrays;

import org.junit.Test;

public class Demo {
	@Test
	public void testing() {
		Solution s = new Solution();
		
		char[] str = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g'};
		s.rotateString(str, 3);
		
		System.out.println(Arrays.toString(str));
	}
}
