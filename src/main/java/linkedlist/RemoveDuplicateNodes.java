package linkedlist;

import java.util.HashSet;

/**
 * @Author: suruomo
 * @Date: 2021/9/28 14:41
 * @Description:
 * 面试题 02.01. 移除重复节点
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 */
public class RemoveDuplicateNodes {
    public ListNode removeDuplicateNodes(ListNode head) {
        if (head==null){
            return head;
        }
        HashSet<Integer> set=new HashSet<>();
        set.add(head.val);
        ListNode pos=head;
        while (pos.next!=null){
            ListNode cur=pos.next;
            if (set.add(cur.val)){
                pos=pos.next;
            }else {
                pos.next=pos.next.next;
            }
        }
        return head;
    }
}
