package interview;

/**
 * @Author: suruomo
 * @Date: 2021/7/30 14:47
 * @Description:
 * 从 0,1,2,...,n 这 n+1 个数中选择 n 个数，
 * 选择出的数字依然保持有序，找出这 n 个数中缺失的那个数，要求 O(n) 或 O(log(n)) 并尽可能小。
 */
public class LostNumber {
    public int solve (int[] a) {
        int i=0;
        int j=a.length-1;
        int mid=0;
        while (i<j){
            mid=i+(j-i)/2;
            if (a[mid]>mid){
                j=mid;
            }else {
                i=mid+1;
            }
        }
        return a[i]==i?i+1:i;
    }
}
