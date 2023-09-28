package offer;

/**
 * @Author: suruomo
 * @Date: 2021/5/18 10:31
 * @Description: 剑指 Offer 22. 链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 如果该链表长度小于k，请返回空。
 */
public class FindKthToTail {
    public class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode FindKthToTail (ListNode pHead, int k) {
        if (pHead==null||k<0){
            return null;
        }
        ListNode pre=pHead,cur=pHead;
        while (k>0){
            if (cur==null){
                return cur;
            }
            cur=cur.next;
            k--;
        }
        while (cur!=null){
            cur=cur.next;
            pre=pre.next;
        }
        return pre;
    }

    /**
     * 方法二
     * @param head
     * @param k
     * @return
     */
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head==null||k<0){
            return null;
        }
        ListNode pre=head;
        int n=k;
        while (n>1){
            pre=pre.next;
            n--;
        }
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode cur=dummy;
        while (pre.next!=null){
            pre=pre.next;
            cur=cur.next;
        }
        return cur.next;
    }
}
