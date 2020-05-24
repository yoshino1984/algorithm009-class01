package medium;

/**
 * 循环双端队列
 *
 **/
public class MyCircularDeque {

    /** 元素 */
    private final int[] elementItems;
    /** 头部索引：指向第一个有效数字之前一位 */
    private int frontIndex;
    /** 尾部索引：指向最后一个有效数字 */
    private int rearIndex;
    /** 容量 = 实际容量 + 1 */
    private final int capacity;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        // 为了判断队列的满与空，需要特别留出一个位置，因此满足容量
        elementItems = new int[k + 1];
        capacity = elementItems.length;
        frontIndex = 0;
        rearIndex = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        elementItems[frontIndex] = value;
        frontIndex = (frontIndex - 1 + capacity) % (capacity);
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        rearIndex = (rearIndex + 1) % (capacity);
        elementItems[rearIndex] = value;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        frontIndex = (frontIndex + 1) % (capacity);
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        rearIndex = (rearIndex - 1 + capacity) % (capacity);
        return true;

    }

    /** Get the front item from the deque. */
    public int getFront() {
        return isEmpty() ? -1 : elementItems[(frontIndex + 1) % (capacity)];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return isEmpty() ? -1 : elementItems[rearIndex];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return frontIndex == rearIndex;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return (rearIndex + 1) % capacity == frontIndex;
    }

    /**
     * Your medium.MyCircularDeque object will be instantiated and called as such:
     * medium.MyCircularDeque obj = new medium.MyCircularDeque(k);
     * boolean param_1 = obj.insertFront(value);
     * boolean param_2 = obj.insertLast(value);
     * boolean param_3 = obj.deleteFront();
     * boolean param_4 = obj.deleteLast();
     * int param_5 = obj.getFront();
     * int param_6 = obj.getRear();
     * boolean param_7 = obj.isEmpty();
     * boolean param_8 = obj.isFull();
     */

    public static void main(String[] args) {
        MyCircularDeque obj = new MyCircularDeque(5);
        obj.insertFront(7);
        obj.insertLast(0);
        System.out.println(obj.getFront());
    }

}
