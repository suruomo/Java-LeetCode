package linkedlist;

/**
 * @author: suruomo
 * @date: 2021/8/15 19:37
 * @description:
 * 82. 删除排序链表中的重复元素 II
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，
 * 请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。
 *
 * 返回同样按升序排列的结果链表。
 */
public class DeleteDuplicates {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode cur=dummy;
        while (cur.next!=null&&cur.next.next!=null){
            if (cur.next.val==cur.next.next.val){
                int x=cur.next.val;
                while (cur.next!=null&&cur.next.val==x){
                    cur.next=cur.next.next;
                }
            }else {
                cur=cur.next;
            }
        }
        return dummy.next;
    }
}
