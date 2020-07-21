package chapter2;

import java.util.Deque;
import java.util.LinkedList;

public class DequeBase {
    public static void main(String[] args) {
        //双端队列
        Deque<String> deque = new LinkedList<String>();
        deque.offerFirst("a");
        deque.offerFirst("b");
        deque.offerFirst("c");
        System.out.println(deque);

        String str = deque.peekFirst();
        System.out.println(str);
        System.out.println(deque);

        while (deque.size() > 0) {
            System.out.println(deque.pollFirst());
        }
        System.out.println(deque);
    }
}
