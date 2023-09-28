package advanced.tree;

/**
 * @author: suruomo
 * @date: 2021/8/13 15:46
 * @description: 298. 二叉树最长连续序列（自顶向下）
 * 给你一棵指定的二叉树，请你计算它最长连续序列路径的长度。
 *
 * 该路径，可以是从某个初始结点到树中任意结点，通过「父 - 子」关系连接而产生的任意路径。
 *
 * 这个最长连续的路径，必须从父结点到子结点，反过来是不可以的。
 */
public class LongestConsecutive {
    class TreeNode{
        int val=0;
        TreeNode left=null;
        TreeNode right=null;
    }
    private int maxLength=0;

    public int longestConsecutive(TreeNode root) {
        dfs(root,null,0);
        return maxLength;
    }

    /**
     *
     * @param root
     * @param parent 父节点
     * @param length
     */
    private void dfs(TreeNode root, TreeNode parent, int length) {
        if (root==null){
            return;
        }
        length=(parent!=null&&(root.val==parent.val+1))?length+1:1;
        maxLength=Math.max(maxLength,length);
        dfs(root.left,root,length);
        dfs(root.right,root,length);
    }
}
