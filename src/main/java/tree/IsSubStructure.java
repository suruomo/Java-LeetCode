package tree;

/**
 * @Author: suruomo
 * @Date: 2021/8/18 9:39
 * @Description: 572. 另一棵树的子树
 * 给你两棵二叉树 root 和 subRoot 。检验 root 中是否包含和 subRoot 具有相同结构和节点值的子树。如果存在，返回 true ；否则，返回 false 。
 *
 * 二叉树 tree 的一棵子树包括 tree 的某个节点和这个节点的所有后代节点。tree 也可以看做它自身的一棵子树。
 *
 *
 * 注意该题和offer不太一样！！！！！！！
 */
public class IsSubStructure {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val=x;
        }
    }

    /**
     * 遍历A的每个结点，判断B是否是A的子结构
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        // 返回true三种情况 A.B都不为空
        // 1. A为根结点包含B
        // 2. B在A的左子树中
        // 3. B在A的右子树中
        // 否则如果A.B任一为null,返回false
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    /**
     * 判断结点A,B是否相等
     * @param A
     * @param B
     * @return
     */
    private boolean recur(TreeNode A,TreeNode B) {
        // 终止条件1：A.B已经遍历完毕
        if (A==null&&B==null){
            return true;
        }
        // 终止条件2
        if (A==null||B==null||A.val!=B.val){
            return false;
        }
        // 递归过程，判断左右结点是否相等
        return recur(A.left,B.left)&&recur(A.right,B.right);
    }
}
