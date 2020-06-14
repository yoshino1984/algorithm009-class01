package medium;

public class FindMinimumInRotatedSortedArray {

    /**
     * 二分查找，判断每个落点的左右值与当前值的大小，注意0 1边界值
     * 时间复杂度O(logN)
     */
    public static int findMin(int[] nums) {
        if (nums[0] <= nums[nums.length - 1]) {
            return nums[0];
        }
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            } if (nums[mid] < nums[mid - 1]) {
                return nums[mid];
            } else if (nums[mid] > nums[0]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return nums[0];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[] {3, 4, 5, 1, 2}));
        System.out.println(findMin(new int[] {4,5,6,7,0,1,2}));
        System.out.println(findMin(new int[] {4,5,6,7,0}));
        System.out.println(findMin(new int[] {0,4,5,6,7}));
        System.out.println(findMin(new int[] {4,5,1,2, 3}));
    }

}
