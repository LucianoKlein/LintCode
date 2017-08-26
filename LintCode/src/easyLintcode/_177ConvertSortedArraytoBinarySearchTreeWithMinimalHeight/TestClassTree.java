package easyLintcode._177ConvertSortedArraytoBinarySearchTreeWithMinimalHeight;

import org.junit.Test;

import util.treehelper.Tree;
import util.treehelper.TreeNode;

public class TestClassTree {
	@Test
	public void test() {
		int[] A = new int[]{1,2,3,4,5,6,7,8};
		Solution solution = new Solution();
		TreeNode result = solution.sortedArrayToBST(A);
		Tree tree = new Tree(result);
		tree.imShow();
		while(true);
	}
}
