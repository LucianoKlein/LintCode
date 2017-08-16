package util.treehelper;
import java.awt.Color;
import java.util.ArrayList;

import org.StructureGraphic.v1.DSTreeNode;

public class Tree {
	public TreeNode head;
	
	public Tree(String data) {
		head = buildTree(data);
	}
	
	public class TreeNode implements DSTreeNode {
		private TreeNode left;
		private TreeNode right;
		private int val;
		
		
		@Override
		public DSTreeNode[] DSgetChildren() {
			// TODO Auto-generated method stub
			return new DSTreeNode[]{left, right};
		}

		@Override
		public Color DSgetColor() {
			// TODO Auto-generated method stub
			return Color.BLACK;
		}

		@Override
		public Object DSgetValue() {
			// TODO Auto-generated method stub
			return this.val;
		}
		
		public TreeNode(int val) {
			this.val = val;
			this.left = this.right = null;
		}
		
	}
	
	public TreeNode buildTree(String target) {
		return deserialize(target);
	}

	public String serialize(TreeNode root) {
		if (root == null) {
			return "{}";
		}
		ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
		queue.add(root);
		for (int i = 0; i < queue.size(); i++) {
			TreeNode node = queue.get(i);
			// 如果扫描到空节点, 那么就跳过本轮.
			if (node == null) {
				continue;
			}
			// 这里会加入所有的节点进队列, 即使子节点是空节点
			queue.add(node.left);
			queue.add(node.right);
		}
		// 把结尾的那些空树都删掉
		while (queue.get(queue.size() - 1) == null) {
			queue.remove(queue.size() - 1);
		}

		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append(queue.get(0).val);

		for (int i = 1; i < queue.size(); i++) {
			if (queue.get(i) == null) {
				sb.append(",#");
			} else {
				sb.append(",");
				sb.append(queue.get(i).val);
			}
		}
		sb.append("}");
		return sb.toString();
	}

	public TreeNode deserialize(String data) {
		if (data.equals("{}")) {
			return null;
		}
		//java是左闭右开, 把大括号去掉, 然后用,来分割成数组
		String[] vals = data.substring(1,  data.length() - 1).split(",");
		ArrayList<TreeNode> queue = new ArrayList<>();
		//建立头结点
		TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
		queue.add(root);
		int index = 0;
		boolean isLeftChild = true;
		//注意有两个索引, 一个index, 是遍历根节点的, 在queue里边遍历; 
		//还有一个i 是遍历子节点的, 在vals里边遍历
		for (int i = 1; i < vals.length; i++) {
			//如果不是空节点
			if (!vals[i].equals("#")) {
				TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
				//i是左节点,那么加在index的左边
				if (isLeftChild) {
					queue.get(index).left = node;
				} else {//i是右节点, 那么就加在index的右边
					queue.get(index).right = node;
				}
				//add方法属于list, 只有本节点不为空的时候, queue才能进入下一个
				queue.add(node);
			}
			//是右节点的话, 就要去处理下一个节点了
			if (!isLeftChild) {
				index++;
			}
			isLeftChild = !isLeftChild;
		}
		return root;
	}
}
