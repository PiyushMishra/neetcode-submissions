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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode first = l1;
        ListNode second = l2;
        ListNode list = new ListNode();
        ListNode ans = list;

        int carry = 0;

        while(first != null && second != null) {
            int sum = first.val + second.val + carry;
            int value = sum%10;
            list.next = new ListNode(value);
            list = list.next;
            carry = sum/10;    
            first = first.next;
            second = second.next;
        }

        while(first != null) {
            int sum = first.val + carry;
            int value = sum%10;
            list.next = new ListNode(value);
            list = list.next;
            carry = sum/10;    
            first = first.next;
        }

        while(second != null) {
            int sum = second.val + carry;
            int value = sum%10;
            list.next = new ListNode(value);
            list = list.next;
            carry = sum/10;    
            second = second.next;
        }
        if(carry!=0) {
            list.next = new ListNode(carry);
        }
        return ans.next;
        
    }
}
