package linkedlist;

/**
 * @author 苏若墨 19. 删除链表的倒数第 N 个结点
 * 问题：Given a linked list, remove the n-th node from the end of list and return its head.
 * <p>
 * Example:
 * <p>
 * Given linked list: 1->2->3->4->5, and n = 2.
 * <p>
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * 思路：
 * 双指针，指针A先移动n次， 指针B再开始移动。当A的下一个null的时候， 指针b的位置下一个正好是倒数n
 */
public class RemoveNthNode {
    static class ListNode {        //节点类
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head==null||n<=0){
            return head;
        }
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode pre=head;
        ListNode cur=dummy;
        for (int i = 1; i <n; i++) {
            pre=pre.next;
        }
        while (pre.next!=null){
            cur= cur.next;
            pre=pre.next;
        }
        cur.next=cur.next.next;
        return dummy.next;
    }

    ListNode remove(ListNode head, int n) {
        ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode p = preHead;
        ListNode q = preHead;
        int count = 0;
        if (head == null) {
            System.out.println("链表为空！无法执行相应操作");
        } else {
            while (p.next != null) {
                if (count == n) {
                    q = q.next;
                }
                if (count != n) {
                    count++;
                }
                p = p.next;
            }
        }
        q.next = q.next.next;
        return preHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 2; i < 5; i++) {
            ListNode l = new ListNode(i);
            cur.next = l;
            cur = cur.next;
        }
        RemoveNthNode re = new RemoveNthNode();
        head = re.remove(head, 3);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
