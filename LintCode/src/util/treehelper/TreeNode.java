package util.treehelper;

public class TreeNode {
	public int val;
	public TreeNode left, right;

	public TreeNode(int val) {
		this.val = val;
		this.left = this.right = null;
	}
	
	public static TreeNode buildTree(String target) {
		return deserialize(target);
	}
	
	public static String serialize(TreeNode root) {
		
		return null;
	}
	
	public static TreeNode deserialize(String target) {
		return null;
	}
}
