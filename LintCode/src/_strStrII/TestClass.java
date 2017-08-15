package _strStrII;

import org.junit.Test;

public class TestClass {
	@Test
	public void test() {
		String source = "abcdef";
		String target = "bcd";
		Solution s = new Solution();
		int result = s.strStr2(source, target);
		System.out.println(result);
	}
}
