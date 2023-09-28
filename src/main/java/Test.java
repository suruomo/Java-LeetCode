import java.util.ArrayList;
import java.util.List;

/**
 * @Author: suruomo
 * @Date: 2021/7/28 10:42
 * @Description:
 */
public class Test {
    class ListNode{
        int val;
        ListNode next;
    }
    public boolean isPail (ListNode head) {
       if (head==null||head.next==null){
           return true;
       }
       ListNode cur=head;
       List<Integer> list=new ArrayList<>();
       while (cur!=null){
           list.add(cur.val);
           cur=cur.next;
       }
       int[] nums=new int[list.size()];
        for (int i = 0; i <list.size() ; i++) {
            nums[i]=list.get(i);
        }
        return isPalindrome(nums);
    }

    private boolean isPalindrome(int[] nums) {
        int i=0;
        int j=nums.length-1;
        while (i<j){
            if (nums[i]!=nums[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
