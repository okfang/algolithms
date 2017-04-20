package leetcode.hard;

import leetcode.ListNode;

import java.util.Arrays;

/**
 * Created by tjoe on 2017/4/19.
 */
public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null){
            return null;
        }
        if (lists.length == 0){
            return null;
        }else if (lists.length == 1){
            return lists[0];
        }else if (lists.length == 2){
            return mergeTwoLists(lists[0], lists[1]);
        }else {
            int mid = lists.length / 2;
            ListNode node1 = mergeKLists(Arrays.copyOfRange(lists,0,mid));
            ListNode node2 = mergeKLists(Arrays.copyOfRange(lists,mid,lists.length));
            return mergeTwoLists(node1, node2);
        }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null){
            return l2;
        }
        if (l2 == null){
            return l1;
        }
        ListNode mergeHead;
        if (l1.val < l2.val){
            mergeHead = l1;
            l1.next = mergeTwoLists(l1.next, l2);
        }else{
            mergeHead = l2;
            l2.next = mergeTwoLists(l1, l2.next);
        }
        return mergeHead;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        ListNode l2 =  null;
        ListNode l3 = new ListNode(-1);
        MergeKSortedLists mk = new MergeKSortedLists();
        ListNode[] listNodes = {l1, l2, l3};

//        int mid = listNodes.length / 2;
//        ListNode[] node1 = Arrays.copyOfRange(listNodes,0, mid);
//        ListNode[] node2 = Arrays.copyOfRange(listNodes, mid, listNodes.length);
//        System.out.println(node1.length);
//        System.out.println(node2.length);
//
//        for (ListNode a: node1){
//            System.out.println(a.val);
//        }
//        System.out.println();
//        for (ListNode b: node2){
//            if (b == null){
//                System.out.println("null");
//            }else {System.out.println(b.val);}
//        }

        ListNode head = mk.mergeKLists(listNodes);
        while (head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}


