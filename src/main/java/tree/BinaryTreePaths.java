package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: suruomo
 * @date: 2021/1/5 11:42
 * @description: 257. 二叉树的所有路径
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 */
public class BinaryTreePaths {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode  right;
        TreeNode(int x){
            val=x;
        }
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        constructPaths(root, "", paths);
        return paths;
    }

    public void constructPaths(TreeNode root, String path, List<String> paths) {
        if (root != null) {
            StringBuffer pathSB = new StringBuffer(path);
            pathSB.append(Integer.toString(root.val));
            if (root.left == null && root.right == null) {  // 当前节点是叶子节点
                paths.add(pathSB.toString());  // 把路径加入到答案中
            } else {
                pathSB.append("->");  // 当前节点不是叶子节点，继续递归遍历
                constructPaths(root.left, pathSB.toString(), paths);
                constructPaths(root.right, pathSB.toString(), paths);
            }
        }
    }

    /**
     * 回溯
     * @param root
     * @return
     */
    public List<String> binaryTreePaths1(TreeNode root) {
        List<String> res = new ArrayList<>();
        List<TreeNode> path = new ArrayList<>();
        dfs(root, path, res);
        return res;
    }

    private void dfs(TreeNode root, List<TreeNode> path, List<String> res) {
        if (root.left == null && root.right == null) { // 如果遍历到了叶子节点就输出一条路径
            StringBuilder tmp = new StringBuilder();
            for (TreeNode node : path) {
                tmp.append(node.val);
                tmp.append("->");
            }
            res.add(tmp.toString() + root.val);
            return;
        }
        path.add(root); //添加结点
        if (root.left != null) // 左节点不为空就继续遍历左子树
        {
            dfs(root.left, path, res);
        }
        if (root.right != null) // 右节点不为空就继续遍历右子树
        {
            dfs(root.right, path, res);
        }
        path.remove(root); // 移除结点
    }
}
