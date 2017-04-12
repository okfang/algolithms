package leetcode;

import java.util.List;

/**
 * Created by tjoe on 2017/4/11.
 * Given a linked list, remove the nth node from the end of list and return its head.
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 *
 *
 */
public class RemoveNthNode {
    public ListNode removeNthFromEnd(ListNode head, int n) {
//        int size = 1;
//        ListNode current = head;
//        while (current.next != null){
//            size++;
//            current = current.next;
//        }
//        int index = size - n;
//        if (index == 0){
//            return head.next;
//        }
//        ListNode temp = head;
//        int count = 1;
//        while(count < index){
//            temp = temp.next;
//            count++;
//        }
//        if (index == size){
//            temp.next = null;
//        }else {
//            temp.next = temp.next.next;
//        }
//        return head;

        //利用两个指针，快指针和慢指针，让其间隔为n+1, 初始化快指针的位置为n+1,
        // 同时移动快指针和满指针，当快指针到达链尾的时候，满指针到达需要删除的前一个位置
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;

        //Move fast in front so that the gap between slow and fast becomes n
        for(int i=1; i<=n+1; i++)   {
            fast = fast.next;
        }
        //Move fast to the end, maintaining the gap
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode current = head;
        int count = 2;
        while (count <=5){
            current.next = new ListNode(count);
            current = current.next;
            count++;
        }
        RemoveNthNode rn = new RemoveNthNode();

        ListNode temp = rn.removeNthFromEnd(head, 2);
        while (temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
