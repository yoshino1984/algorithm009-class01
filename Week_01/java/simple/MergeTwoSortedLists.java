package simple;

import java.util.List;

/**
 * 合并两个有序链表
 * 时间复杂度O(N) N=l1+l2的节点和
 **/
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prevHead = new ListNode(-1);
        ListNode cur = prevHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        // 合并剩余未遍历完的链表
        cur.next = l1 != null ? l1 : l2;

        return prevHead.next;
    }
}


