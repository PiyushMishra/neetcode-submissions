/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode fast = head;
    ListNode slow = head;

    // Move fast pointer n steps ahead
    int i = 0;
    while (i < n) {
      fast = fast.next;
      i++;
    }

    // If fast is null, it means we need to remove the head node
    if (fast == null) {
      return head.next;
    }

    // Move both pointers until fast reaches the end
    while (fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }

    // Remove the nth node from the end
    slow.next = slow.next.next;

    return head;
  }
}

