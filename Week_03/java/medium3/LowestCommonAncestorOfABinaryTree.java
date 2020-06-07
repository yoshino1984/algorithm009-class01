package medium3;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 二叉树的最近公共祖先
 *
 * @author wangxin
 * 2020/6/7 21:18
 * @since
 **/
public class LowestCommonAncestorOfABinaryTree {

    /**
     * 递归方式
     * 时间复杂度O(N)
     * 空间复杂度O(N) 二叉树最坏情况下 递归栈的深度
     */
    TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.dfs(root, p, q);
        return ans;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean left = dfs(root.left, p, q);
        boolean right = dfs(root.right, p, q);
        if ((left && right) || ((root.val == p.val || root.val == q.val) && (left || right))) {
            ans = root;
        }

        return left || right || root.val == p.val || root.val == q.val;
    }


    /**
     * 存储父节点的方式
     * 时间复杂度O(N)
     * 空间复杂度O(N) 二叉树最坏情况下 递归栈的深度
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        nodeParentMap = new HashMap<>();
        visited = new HashSet<>();
        this.dfs2(root);
        TreeNode cur = p;
        while (cur != null) {
            visited.add(cur.val);
            cur = nodeParentMap.get(cur.val);
        }

        cur = q;
        while (!visited.contains(cur.val)) {
            visited.add(cur.val);
            cur = nodeParentMap.get(cur.val);
        }
        return cur;
    }

    private void dfs2(TreeNode root) {
        if (root.left != null) {
            nodeParentMap.put(root.left.val, root);
            dfs2(root.left);
        }

        if (root.right != null) {
            nodeParentMap.put(root.right.val, root);
            dfs2(root.right);
        }
    }

    Map<Integer, TreeNode> nodeParentMap;
    Set<Integer> visited;
}
