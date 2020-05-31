package medium;


import simple.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * 二叉树前序遍历
 * @since
 **/
public class BinaryTreePreorderTraversal {

    /**
     * recursive
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> retList = new ArrayList<>();
        helper(root, retList);
        return retList;
    }

    private void helper(TreeNode node, List<Integer> retList) {
        if (node == null) {
            return;
        }
        retList.add(node.val);
        helper(node.left, retList);
        helper(node.right, retList);
    }

    /**
     * iteration
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (Objects.isNull(root)) {
            return ans;
        }

        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pollFirst();
            ans.add(cur.val);
            if (cur.right != null) {
                stack.addFirst(cur.right);
            }
            if (cur.left != null) {
                stack.addFirst(cur.left);
            }
        }

        return ans;
    }
}
