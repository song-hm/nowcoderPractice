package com.shm.toOffer;

/**时间空间效率的平衡	数组中的逆序对
 * 题目描述
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。
 * 即输出P%1000000007
 * 输入描述:
 * 题目保证输入的数组中没有的相同的数字
 *
 * 数据范围：
 *
 * 	对于%50的数据,size<=10^4
 *
 * 	对于%75的数据,size<=10^5
 *
 * 	对于%100的数据,size<=2*10^5
 *
 * 示例1
 * 输入
 * 复制
 * 1,2,3,4,5,6,7,0
 * 输出
 * 复制
 * 7
 *
 */
public class InversePairs {
    public static void main(String[] args) {
        int[] array = new int[]{5, 3, 8, 6, 9, 2, 1, 7};
        InversePairs_2(array);
        System.out.println(count);
    }

    //0(n^2)超时
    public int InversePairs(int [] array) {
        int p = 0;
        for (int i=0;i<array.length-1;i++){
            for (int j=i+1;j<array.length;j++){
                if (array[i] > array[j]){
                    p++;
                }
            }
        }
        return p%1000000007;
    }

    static int[] aux;

    //定义为long类型,int类型会溢出

    static long count = 0;

    /**
     *
     * @param array
     * @return
     */
    public static int InversePairs_2(int [] array) {
        if (array == null || array.length == 0){
            return 0;
        }
        Up2DownMergeSort(array);
        return (int)(count%1000000007);
    }

    public static void Up2DownMergeSort(int[] arr){
        aux = new int[arr.length];
        MSort(arr,0,arr.length-1);
    }

    public static  void Down2UpMergeSort(int[] arr){
        aux = new int[arr.length];
        for (int s=1;s<arr.length;s+=s){
            for (int i=0;i<arr.length-s;i+=s+s){
                merge(arr,i,i+s-1,Math.min(i+s+s-1,arr.length-1));
            }
        }
    }

    public static void MSort(int[] arr,int l,int h){
        if (h<=l){
            return;
        }
        int mid = l + (h-l)/2;
        MSort(arr,l,mid);
        MSort(arr,mid+1,h);
        merge(arr,l,mid,h);
    }

    public static void merge(int[] arr,int l,int mid,int h){
        int j,k,i;
        // 将数据复制到辅助数组
        for (int p = l;p<=h;p++){
            aux[p] = arr[p];
        }

        //将aux中的记录由小到大归并入nums
        for (k=l,j=mid+1;l<=mid && j<=h;k++){
            if (aux[l] < aux[j]){
                arr[k] = aux[l++];
            }else{
                arr[k] = aux[j++];
                count += (mid-l+1);
            }
        }
        if (l<=mid){
            //将剩余的aux[i..m]复制到nums
            for (i=0;i<=mid-l;i++){
                arr[k+i] = aux[l+i];
            }
        }
        if (j<=h){
            //将剩余的aux[j..n]复制到nums
            for (i=0;i<=h-j;i++){
                arr[k+i] = aux[j+i];
            }
        }
    }
}
