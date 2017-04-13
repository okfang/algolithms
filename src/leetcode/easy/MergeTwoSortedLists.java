package leetcode.easy;

import leetcode.ListNode;

/**
 * Created by tjoe on 2017/4/12.
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 * 解决方法：使用
 */
public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode mergeHead;
        if (l1.val > l2.val){
            mergeHead = l1;
            l1.next = mergeTwoLists(l1.next, l2);
        }else{
            mergeHead = l2;
            l2.next = mergeTwoLists(l1, l2.next);
        }
        return mergeHead;
    }

    public static void main(String[] args) {
        MergeTwoSortedLists m = new MergeTwoSortedLists();
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(2);
        ListNode l2 = new ListNode(2);
        ListNode l = m.mergeTwoLists(l1, l2);
        while (l != null){
            System.out.println(l.val);
            l = l.next;
        }
    }
}


