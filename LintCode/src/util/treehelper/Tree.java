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
			// ���ɨ�赽�սڵ�, ��ô����������.
			if (node == null) {
				continue;
			}
			// �����������еĽڵ������, ��ʹ�ӽڵ��ǿսڵ�
			queue.add(node.left);
			queue.add(node.right);
		}
		// �ѽ�β����Щ������ɾ��
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
		//java������ҿ�, �Ѵ�����ȥ��, Ȼ����,���ָ������
		String[] vals = data.substring(1,  data.length() - 1).split(",");
		ArrayList<TreeNode> queue = new ArrayList<>();
		//����ͷ���
		TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
		queue.add(root);
		int index = 0;
		boolean isLeftChild = true;
		//ע������������, һ��index, �Ǳ������ڵ��, ��queue��߱���; 
		//����һ��i �Ǳ����ӽڵ��, ��vals��߱���
		for (int i = 1; i < vals.length; i++) {
			//������ǿսڵ�
			if (!vals[i].equals("#")) {
				TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
				//i����ڵ�,��ô����index�����
				if (isLeftChild) {
					queue.get(index).left = node;
				} else {//i���ҽڵ�, ��ô�ͼ���index���ұ�
					queue.get(index).right = node;
				}
				//add��������list, ֻ�б��ڵ㲻Ϊ�յ�ʱ��, queue���ܽ�����һ��
				queue.add(node);
			}
			//���ҽڵ�Ļ�, ��Ҫȥ������һ���ڵ���
			if (!isLeftChild) {
				index++;
			}
			isLeftChild = !isLeftChild;
		}
		return root;
	}
}
