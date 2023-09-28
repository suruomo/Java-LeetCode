package advanced.linkedList;

/**
 * @Author: suruomo
 * @Date: 2021/7/28 9:40
 * @Description: 369 给单链表加一
 * 用一个 非空 单链表来表示一个非负整数，然后将这个整数加一。
 *
 * 你可以假设这个整数除了 0 本身，没有任何前导的 0。
 *
 * 这个整数的各个数位按照 高位在链表头部、低位在链表尾部 的顺序排列。
 */
public class LinkedList {
    class ListNode{
        int val=0;
        ListNode next=null;
        public ListNode(){};
        public ListNode(int val){
            this.val=val;
        }
    }
    public ListNode plusOne(ListNode head) {
        if (head == null) {
            return head;
        }
        int append = helper(head);
        // 1.到头节点没有进位，直接返回
        if (append == 0) {
            return head;
        }
        // 2.到头节点有进位，创建新节点
        ListNode dummyHead = new ListNode(1);
        dummyHead.next = head;
        return dummyHead;
    }

    private int helper(ListNode head){
        //从后向前递归，最后返回1，否则就返回append和head的和与10的商
        if (head == null) {
            return 1;
        }
        int append = helper(head.next);
        int temp = head.val + append;
        head.val = temp % 10;
        return temp / 10;
    }
}
