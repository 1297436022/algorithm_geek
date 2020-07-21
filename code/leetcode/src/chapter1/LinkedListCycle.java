package chapter1;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            next = null;
        }
    }


    public static void main(String[] args) {

    }

    //方法1：暴力求解 哈希表 O(N) O(N)
    public static boolean hasCycle1(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true;
            } else {
                nodesSeen.add(head);
            }
            head = head.next;
        }
        return false;
    }

    //方法2：快慢指针 O(N) O(1)
    //https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/linked-list-cycle-ii-kuai-man-zhi-zhen-shuang-zhi-/
    public static boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                //只有两个元素或者到链表末尾
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }


}
