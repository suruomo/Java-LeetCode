package tree;

import java.util.*;

/**
 * @author: suruomo
 * @date: 2021/8/13 16:05
 * @description: 314. 二叉树的垂直遍历
 * 给定一个二叉树，返回其结点 垂直方向（从上到下，逐列）遍历的值。
 *
 * 如果两个结点在同一行和列，那么顺序则为 从左到右。
 */
public class VerticalOrder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 定义一个位置变量 x，从根节点出发，只要是往左子树走，就减一，往右子树走就加一。
     *
     * 于是，对于每一个节点，都有一个位置变量来描述所在的列。
     *
     * 接着就可以进行 BFS 遍历，现给当前结点标记位置，然后对所在位置的 list 添加当前结点的值即可。
     * @param root
     * @return
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        // 存放当前位置(key)的结果集(value)
        Map<Integer, List<Integer>> res = new TreeMap<>();

        // 存放当前节点（TreeNode）的位置
        Map<TreeNode, Integer> nodeMap = new HashMap<>();
        nodeMap.put(root, 0);

        // 层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int i = nodeMap.get(node);
            // 如果当前位置还没有存储元素的结果集，则初始化 value，并添加元素
            res.computeIfAbsent(i, k -> new ArrayList<>()).add(node.val);
            // 左边向下逐层减 1
            if (node.left != null) {
                queue.add(node.left);
                nodeMap.put(node.left, i - 1);
            }
            // 右边向下逐层加 1
            if (node.right != null) {
                queue.add(node.right);
                nodeMap.put(node.right, i + 1);
            }
        }
        return new ArrayList<>(res.values());
    }
}
