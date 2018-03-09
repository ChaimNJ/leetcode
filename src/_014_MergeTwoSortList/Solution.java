package _014_MergeTwoSortList;

import java.util.List;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

 Example:

 Input: 1->2->4, 1->3->4
 Output: 1->1->2->3->4->4

 */
public class Solution {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = null;
        ListNode pre = null;
        ListNode p = null;
        while(l1!=null && l2!=null){
            if(l1.val < l2.val){
                p = new ListNode(l1.val);
                l1 = l1.next;
            }else{
                p = new ListNode(l2.val);
                l2 = l2.next;
            }
            if(l3 == null){
                l3 = p;
                pre = p;
            }else{
                pre.next = p;
                pre = p;
            }
            p = p.next ;
        }
        if(l1!=null){
            if(l3==null){
                l3 = pre = l1;
            }else{
                pre.next = l1;
            }
        }
        if(l2!=null){
            if(l3==null){
                l3 = pre = l2;
            }else{
                pre.next = l2;
            }
        }
        return l3;
    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode pre = l1;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while(p1!=null&&p2!=null){
            if(p2.val>=p1.val&&p1.next.val>p2.val) {
                p2.next = p1.next;
                p1.next = p2;
                p2 = p2.next;
            }
                pre = p1;
                p1 = p1.next;
        }
        if(p1 == null){

        }
        return null;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
//        ListNode l2 = new ListNode(2);
//        ListNode l3 = new ListNode(4);
//        ListNode l4 = new ListNode(1);
//        ListNode l5 = new ListNode(3);
//        ListNode l6 = new ListNode(4);
//        l1.next = l2;
//        l2.next = l3;
//        l4.next = l5;
//        l5.next = l6;
        ListNode re = mergeTwoLists(null,l1);
        while(re!=null){
            System.out.println(re.val);
            re = re.next;
        }
    }
}
