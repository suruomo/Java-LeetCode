package tree;

/**
 * @Author: suruomo
 * @Date: 2021/9/28 10:42
 * @Description: 437. 路径总和 III
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 */
public class PathSum1 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return 0;
        }
        // 一共三种可能路径
        int ret=sum(root,targetSum);
        ret+=pathSum(root.left,targetSum);
        ret+=pathSum(root.right,targetSum);
        return ret;
    }

    /**
     * 以root为起点向下，和为targetSum的路径数
     * @param root
     * @param targetSum
     * @return
     */
    private int sum(TreeNode root, int targetSum) {
        if (root==null){
            return 0;
        }
        int ans=0;
        int val= root.val;
        if (val==targetSum){
            ans++;
        }
        ans+=sum(root.left,targetSum-val);
        ans+=sum(root.right,targetSum-val);
        return ans;
    }
}
