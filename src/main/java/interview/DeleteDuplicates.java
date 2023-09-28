package interview;

/**
 * @author: suruomo
 * @date: 2021/4/12 11:54
 * @description: 给出一个升序排序的链表，删除链表中的所有重复出现的元素，只保留原链表中只出现一次的元素。
 */
public class DeleteDuplicates {
    class ListNode{
        int val=0;
        ListNode next=null;

        public ListNode(int i) {
            val=i;
        }
    }
    /**
     *
     * @param head ListNode类
     * @return ListNode类
     */
    public ListNode deleteDuplicates (ListNode head) {
     ListNode dummy=new ListNode(-1);
     dummy.next=head;
     ListNode pre=dummy;
     ListNode cur=dummy.next;
     while (cur!=null&&cur.next!=null){
         if (cur.val==cur.next.val){
             ListNode temp=cur.next;
             while (temp!=null&&temp.val==cur.val){
                 temp=temp.next;
             }
             pre.next=temp;
             cur= temp;
         }else {
             pre=pre.next;
             cur=cur.next;
         }

     }
     return dummy.next;
    }

    public ListNode deleteDuplicates1 (ListNode head) {
        if(head==null) {
            return head;
        }
        ListNode temp = head;
        while(temp.next!=null){
            if(temp.val==temp.next.val){
                temp.next=temp.next.next;
            }else{
                temp=temp.next;
            }
        }
        return head;
    }

    public ListNode deleteDuplicates2 (ListNode head) {
        if (head==null||head.next==null){
            return head;
        }
        ListNode cur=head,pre=head;
        while (pre!=null&&pre.next!=null){
            if (pre.val==pre.next.val){
                int val=pre.val;
                while (pre!=null&&pre.val==val){
                    pre=pre.next;
                }
                cur.next=pre;
                cur=pre;
            }else {
                pre=pre.next;
                cur=cur.next;
            }
        }
        return head;
    }
}
