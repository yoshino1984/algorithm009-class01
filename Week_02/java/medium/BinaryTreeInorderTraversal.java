package medium;

import simple.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 中序遍历
 **/
public class BinaryTreeInorderTraversal {

    /**
     * 递归的方式
     * 时间复杂度O(N) n为节点数
     * 空间复杂度(logN ~ N) 最坏空间复杂度为O(N)
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> retList = new ArrayList<>();
        helper(root, retList);
        return retList;
    }

    private void helper(TreeNode node, List<Integer> retList) {
        if (node == null) {
            return;
        }
        helper(node.left, retList);
        retList.add(node.val);
        helper(node.right, retList);
    }

    /**
     * 模拟栈的方式，迭代中序遍历
     * 空间复杂度(logN ~ N) 最坏空间复杂度为O(N)
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> retList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            retList.add(cur.val);
            cur = cur.right;
        }
        return retList;
    }


}
