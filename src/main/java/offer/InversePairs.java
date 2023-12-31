package offer;

/**
 * @Author: suruomo
 * @Date: 2021/8/11 16:27
 * @Description:
 * 剑指offer-35-数组中的逆序对
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
public class InversePairs {
    /**
     * 结果
     */
    private int cnt;

    public int InversePairs(int [] array) {
        MergeSort(array, 0, array.length-1);
        return cnt;
    }

    /**
     * 归并
     * @param array
     * @param start
     * @param end
     */
    private void MergeSort(int[] array, int start, int end){
        if(start>=end) {
            return;
        }
        int mid = (start+end)/2;
        MergeSort(array, start, mid);
        MergeSort(array, mid+1, end);
        MergeOne(array, start, mid, end);
    }
    private void MergeOne(int[] array, int start, int mid, int end){
        int[] temp = new int[end-start+1];
        int k=0,i=start,j=mid+1;
        while(i<=mid && j<= end){
//如果前面的元素小于后面的不能构成逆序对
            if(array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else{
//如果前面的元素大于后面的，那么在前面元素之后的元素都能和后面的元素构成逆序对
                temp[k++] = array[j++];
                cnt = (cnt + (mid-i+1))%1000000007;
            }
        }
        while(i<= mid) {
            temp[k++] = array[i++];
        }
        while(j<=end) {
            temp[k++] = array[j++];
        }
        for(int l=0; l<k; l++){
            array[start+l] = temp[l];
        }
    }

}
