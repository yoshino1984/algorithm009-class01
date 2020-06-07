package medium3;

import java.util.HashMap;
import java.util.Map;

/**
 * 从前序与中序遍历序列构造二叉树
 *
 * @author wangxin
 * 2020/6/7 21:54
 * @since
 **/
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    /**
     * 递归解法
     * 时间复杂度O(N)
     * 空间复杂度O(N)
     */
    Map<Integer, Integer> inorderValIndexMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = inorder.length;
        inorderValIndexMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            // 建立中序遍历的倒排索引
            inorderValIndexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, 0, len - 1, inorder, 0, len - 1);
    }

    private TreeNode myBuildTree(int[] preorder, int preStart, int preEnd,
                               int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        // 中序遍历节点中的根节点索引
        int inorderRootIndex = inorderValIndexMap.get(root.val);
        // 左子树节点数
        int leftTreeSize = inorderRootIndex - inStart;
        root.left = myBuildTree(preorder, preStart + 1, preStart + leftTreeSize, inorder, inStart, inorderRootIndex - 1);
        root.right = myBuildTree(preorder, preStart + leftTreeSize + 1, preEnd, inorder, inorderRootIndex + 1, inEnd);

        return root;
    }

    public static void main(String[] args) {
        new ConstructBinaryTreeFromPreorderAndInorderTraversal().buildTree(new int[] {3,9,20,15,7}, new int[] {9,3,15,20,7});
    }
}
