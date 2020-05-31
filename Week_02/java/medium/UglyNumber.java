package medium;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 丑数II
 *
 * @author wangxin
 * 2020/5/31 00:21
 * @since
 **/
public class UglyNumber {

    /**
     * 通过最小堆的方式方式获取丑数
     * 时间复杂度O(NlogN) 维护最小堆的
     * 空间复杂度O(N)
     */
    public int nthUglyNumber(int n) {
        long[] uglyNums = new long[n];
        PriorityQueue<Long> heap = new PriorityQueue<>();
        heap.add(1L);
        Set<Long> seen = new HashSet<>();
        seen.add(1L);
        for (int i = 0; i < uglyNums.length; i++) {
            // 获取候选元素中的最小一个
            Long cur = heap.poll();
            uglyNums[i] = cur;
            addUglyNumber(heap, seen, cur * 2);
            addUglyNumber(heap, seen, cur * 3);
            addUglyNumber(heap, seen, cur * 5);
        }
        return (int) uglyNums[n - 1];
    }

    private void addUglyNumber(PriorityQueue<Long> heap, Set<Long> seen, Long uglyNum) {
        if (seen.add(uglyNum)) {
            heap.add(uglyNum);
        }
    }

}
