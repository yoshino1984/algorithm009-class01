package simple;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 队列改写
 **/
public class DequeTest {

    public static void main(String[] args) {
        Deque<String> deque = new LinkedList<String>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);
        String str = deque.getFirst();
        System.out.println(str);
        System.out.println(deque);
        while (deque.size() > 0) {
            System.out.println(deque.pollFirst());
        }
        System.out.println(deque);
    }
}
