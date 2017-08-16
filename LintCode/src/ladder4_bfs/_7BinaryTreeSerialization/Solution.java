package ladder4_bfs._7BinaryTreeSerialization;

import java.util.ArrayList;

import util.treehelper.TreeNode;

public class Solution {
	/**
	 * This method will be invoked first, you should design your own algorithm
	 * to serialize a binary tree which denote by a root node to a string which
	 * can be easily deserialized by your own "deserialize" method later.
	 */
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

	/**
	 * This method will be invoked second, the argument data is what exactly you
	 * serialized at method "serialize", that means the data is not given by
	 * system, it's given by your own serialize method. So the format of data is
	 * designed by yourself, and deserialize it here as you serialize it in
	 * "serialize" method.
	 */
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