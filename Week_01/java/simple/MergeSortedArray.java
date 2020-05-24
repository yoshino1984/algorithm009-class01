package simple;

import java.util.Arrays;

/**
 * 合并两个有序数组
 **/
public class MergeSortedArray {

    /**
     * 直接合并，然后排序
     * 时间复杂度O((m+n)log(m+n))
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    /**
     * 双指针从前向后
     * 移动数组的时间复杂度为O(M)，合并的时间复杂度为O(M+N)，因此时间复杂度为O(M+N)
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        // 首先将nums1后移，然后合并
        for (int i = 0; i < m; i++) {
            nums1[n + m - i - 1] = nums1[m - 1 - i];
        }
        int index1 = n;
        int index2 = 0;
        // 合并
        for (int i = 0; i < m + n; i++) {
            // nums2遍历完，或者 当nums1未遍历完，进行值大小比对
            if (index2 == n || (index1 < (m + n) && nums1[index1] <= nums2[index2])) {
                nums1[i] = nums1[index1++];
            } else {
                nums1[i] = nums2[index2++];
            }
        }
    }

    /**
     * 双指针从后向前
     * 优化上述解法，双指针从后向前遍历，则不需要对数组元素进行迁移
     */
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;

        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] >= nums2[index2]) {
                nums1[index1 + index2 + 1] = nums1[index1--];
            } else {
                nums1[index1 + index2 + 1] = nums2[index2--];
            }
        }

        // index1的未遍历完的情况无需处理
        while (index2 >= 0) {
            nums1[index2] = nums2[index2];
            index2--;
        }
    }
}
