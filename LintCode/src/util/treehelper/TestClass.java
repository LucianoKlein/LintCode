package util.treehelper;

import org.junit.Test;


public class TestClass {
	private final int recWidth = 50;
	private final int recHeight = 50;
	@Test
	public void test() {
		Tree tree = new Tree("{1,2,#,3,#,4}");
		tree.imShow();
		while(true);
	}
	
}
