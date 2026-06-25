// class ListNode {
//     int val;
//     ListNode next;
//     ListNode(int val) { this.val = val; }
// }

class Solution {

    static ListNode left = null;
 
    public void reorderList(ListNode head)
    {
        if(head == null || head.next == null) return;   
        left = head;
        rearrangeH(left, null);
    }
    
    public static void rearrangeH(ListNode curr, ListNode prev)
    {
        if(curr.next != null) rearrangeH(curr.next, curr);
        if(left != null && left.next != null) {
            prev.next = null;
            ListNode saveNext = left.next;
            left.next = curr;
            curr.next = saveNext;
            left = saveNext;
        }
    }
}
