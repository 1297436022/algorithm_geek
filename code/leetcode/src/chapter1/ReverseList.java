package chapter1;

public class ReverseList {

    //方便main函数调用，设为static
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

    public static void main(String[] args) {

    }

    public static ListNode reverseList1(ListNode head) {
        //迭代 O(n)  o(1)
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static ListNode reverseList2(ListNode head) {
        //递归 O(n) O(n)
        //https://leetcode-cn.com/problems/reverse-linked-list/solution/fan-zhuan-lian-biao-by-leetcode/334086
        if (head == null || head.next == null) {
           return head;
        }
        ListNode p = reverseList2(head.next);
        head.next.next = head; //4.next.next -> 4 即 5.next -> 4
        head.next = null; //4.next -> null
        return p;
    }
}
