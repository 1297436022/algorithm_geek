package chapter1;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle2 {

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

    public static ListNode detectCycle1(ListNode head) {
        //哈希表
        Set<ListNode> visited = new HashSet<ListNode>();
        ListNode node = head;
        while (node != null) {
            if(visited.contains(node)) {
                return node;
            }
            visited.add(node);
            node = node.next;
        }
        return null;
    }

    public static ListNode detectCycle2(ListNode head) {
        //快慢指针
        //https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/linked-list-cycle-ii-kuai-man-zhi-zhen-shuang-zhi-/
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
