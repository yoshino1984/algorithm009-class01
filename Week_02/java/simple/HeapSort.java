package simple;

/**
 * 堆排序
 *
 * @author wangxin
 * 2020/5/31 17:42
 * @since
 **/
public class HeapSort {


    private void sort(int[] arr) {
        int len = arr.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(arr, len, i);
        }

        for (int i = len - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    /**
     * 堆化,迭代方式
     */
    void heapify(int arr[], int n, int cur) {
        int maxIndex = cur;
        while (maxIndex < n) {
            int left = maxIndex * 2 + 1;
            int right = maxIndex * 2 + 2;
            if (left < n && arr[maxIndex] < arr[left]) {
                maxIndex = left;
            }
            if (right < n && arr[maxIndex] < arr[right]) {
                maxIndex = right;
            }
            if (maxIndex == cur) {
                return;
            }
            swap(arr, cur, maxIndex);
            cur = maxIndex;
        }
    }

    private void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }


    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        int n = arr.length;

        HeapSort ob = new HeapSort();
        ob.sort(arr);

        System.out.println("Sorted array is");
        printArray(arr);
    }

}
