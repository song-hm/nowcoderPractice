package com.shm.sort;

/**
 *
 * @param <T>
 */
public class HeapSort<T extends Comparable<T>> extends Sort<T> {
    /**
     * 数组第 0 个位置不能有元素
     */
    @Override
    public void sort(T[] nums) {
        int N = nums.length - 1;

        // 构建堆(大顶堆）
        //无序数组建立堆最直接的方法是从左到右遍历数组进行上浮操作。一个更高效的方法是从右至左进行下沉操作，如果
        //一个节点的两个节点都已经是堆有序，那么进行下沉操作可以使得这个节点为根节点的堆有序。叶子节点不需要进行
        //下沉操作，可以忽略叶子节点的元素，因此只需要遍历一半的元素即可。
        for (int k = N / 2; k >= 1; k--) {
            sink(nums, k, N);
        }
        //交换堆顶元素与最后一个元素
        //交换之后需要进行下沉操作维持堆的有序状态。
        while (N > 1) {
            swap(nums, 1, N--);
            sink(nums, 1, N);
        }
    }

    /**当一个节点比子节点来得小，也需要不断地向下进行比较和交换操作，把这种操作称为下沉。一个节点如果
     * 有两个子节点，应当与两个子节点中最大那个节点进行交换。
     *
     * @param nums
     * @param k
     * @param N
     */
    private void sink(T[] nums, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && less(nums, j, j + 1)) {
                j++;
            }
            if (!less(nums, k, j)) {
                break;
            }
            swap(nums, k, j);
            k = j;
        }
    }

    private boolean less(T[] nums, int i, int j) {
        return nums[i].compareTo(nums[j]) < 0;
    }
}