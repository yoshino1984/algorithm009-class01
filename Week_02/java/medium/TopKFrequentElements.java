package medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 前 K 个高频元素
 * @author wangxin
 * 2020/5/31 16:46
 * @since
 **/
public class TopKFrequentElements {

    /**
     * 使用map对各个频率进行统计，使用优先队列，统计前k个元素
     * 时间复杂度 O(Nlogk)
     * 空间复杂度 O(N)
     * @param nums 不考虑为空的情况
     * @param k 不考虑为0的情况
     * @return
     */
    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, AtomicInteger> numCountMap = new HashMap<>();
        for (int num : nums) {
            numCountMap.computeIfAbsent(num, key -> new AtomicInteger()).incrementAndGet();
        }

        // 小顶堆 统计前k大元素
        PriorityQueue<Map.Entry<Integer, AtomicInteger>> priorityQueue = new PriorityQueue<>(
            Comparator.comparingInt(entry -> entry.getValue().get()));
        numCountMap.entrySet().forEach(entry -> {
            if (priorityQueue.size() < k) {
                priorityQueue.add(entry);
            } else if (priorityQueue.peek().getValue().get() < entry.getValue().get()){
                priorityQueue.poll();
                priorityQueue.add(entry);
            }
        });

        return priorityQueue.stream().mapToInt(Map.Entry::getKey).toArray();
    }


    public static void main(String[] args) {
        new TopKFrequentElements().topKFrequent1(new int[] {1,1,1,2,2,3}, 2);
    }
}
