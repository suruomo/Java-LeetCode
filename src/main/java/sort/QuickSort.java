package sort;

import java.util.Arrays;

/**
 * 快速排序
 * @author 苏若墨
 */
public class QuickSort {
    public static void main(String[] args) {
        int []arr = {9,8,7,6,5,4,3,2,1};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 快速排序
     * @param arr 待排序数组
     * @param start 起始下标
     * @param end  终止下标
     */
    private static void quickSort(int[] arr, int start, int end) {
        //如果只有一个元素时终止排序
        if(start>=end){
            return;
        }
        int partition = divide2(arr, start, end);
        //以基准划分两边分别递归的进行快排
        quickSort(arr,start,partition-1);
        quickSort(arr,partition+1,end);
    }

    /**
     * 划分函数，以基准为界限，基准右边的元素都比基准小，基准左边元素都比基准大
     * @param arr 待划分数组
     * @param start 起始下标
     * @param end  终止下标
     * @return  返回基准所在下标
     */
    private static int divide(int[] arr, int start, int end) {
        //选取划分标准
        int base=arr[end];
        while (start<end){
             // 从左向右移动，若当前元素小于基准，满足划分条件，start++继续向右移动
            while(start<end&&arr[start]<=base){
                start++;
            }
            //当前元素大于基准时，进行交换
            if(start<end){
                int temp=arr[start];
                arr[start]=arr[end];
                arr[end]=temp;
                end--;
            }
            // 从右向左移动，若当前元素大于基准，满足划分条件，end--继续向左移动
            while (start<end&&arr[end]>=base){
                end--;
            }
            //当前元素小于基准时，进行交换
            if(start<end){
                int temp=arr[start];
                arr[start]=arr[end];
                arr[end]=temp;
                start++;
            }
        }
        //返回基准所在下标，end或者start都可以
        return end;
    }
    private static int divide1(int[] arr, int start, int end) {
        int temp=arr[end];
        while (start<end){
            while (start<end&&arr[start]<=temp){
                start++;
            }
            if (start<end){
                swap(arr,start,end);
                end--;
            }
            while (start<end&&arr[end]>=temp){
                end--;
            }
            if (start<end){
                swap(arr,start,end);
                start++;
            }
        }
        return start;
    }

    private static void swap(int[] arr, int start, int end) {
        int t=arr[start];
        arr[start]=arr[end];
        arr[end]=t;
    }
    private static int divide2(int[] arr, int start, int end) {
        int temp=arr[end];
        while (start<end){
            while (start<end&&arr[start]<=temp){
                start++;
            }
            arr[end]=arr[start];
            while (start<end&&arr[end]>=temp){
                end--;
            }
            arr[start]=arr[end];
        }
        arr[start]=temp;
        return start;
    }
}
