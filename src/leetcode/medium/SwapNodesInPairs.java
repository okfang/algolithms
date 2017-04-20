package leetcode.medium;

import leetcode.ListNode;

/**
 * Created by tjoe on 2017/4/19.
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }else {
            ListNode n = head.next;
            head.next = swapPairs(head.next.next);
            n.next = head;
            return n;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
        SwapNodesInPairs sn = new SwapNodesInPairs();
        ListNode index = sn.swapPairs(head);

        while (index != null){
            System.out.println(index.val);
            index = index.next;
        }

    }
}
