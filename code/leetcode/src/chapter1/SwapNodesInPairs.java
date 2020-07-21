package chapter1;

public class SwapNodesInPairs {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

    }

    public static ListNode swapPairs1(ListNode head) {
        //迭代 O(n)  O(1)
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;
        while (temp.next != null && temp.next.next != null) {
            ListNode start = temp.next;
            ListNode end = temp.next.next;
            temp.next = end;
            start.next = end.next;
            end.next = start;
            temp = start;
        }
        return pre.next;
    }

    public static ListNode swapPairs2(ListNode head) {
        //递归 O(n)  O(n)
        if (head == null || head.next == null) {
            //如果链表为空 或 只有一个结点
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs2(next.next);
        next.next = head;
        return next;
    }
}
