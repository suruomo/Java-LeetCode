package tree;


import java.util.*;

/**
 * @Author: suruomo
 * @Date: 2021/8/9 11:29
 * @Description: 662. 二叉树最大宽度
 * 给定一个二叉树，编写一个函数来获取这个树的最大宽度。树的宽度是所有层中的最大宽度。这个二叉树与满二叉树（full binary tree）结构相同，但一些节点为空。
 *
 * 每一层的宽度被定义为两个端点（该层最左和最右的非空节点，两端点间的null节点也计入长度）之间的长度。
 */
public class WidthOfBinaryTree {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
    }
    public int widthOfBinaryTree(TreeNode root) {
        if (root==null){
            return 0;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        // 记录每个节点的索引
        LinkedList<Integer> indexList=new LinkedList<>();
        int ans=1;
        indexList.add(1);
        while (!queue.isEmpty()){
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node=queue.poll();
                // 当前节点索引
                int index=indexList.removeFirst();
                if(node.left!=null){
                    queue.offer(node.left);
                    indexList.add(index*2);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                    indexList.add(index*2+1);
                }
            }
            if (indexList.size()>=2){
                ans=Math.max(ans,indexList.getLast()-indexList.getFirst()+1);
            }
        }
        return ans;
    }
}
