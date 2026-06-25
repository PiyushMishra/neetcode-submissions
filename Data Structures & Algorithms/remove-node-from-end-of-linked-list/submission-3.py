# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        
        temp = head

        while n > 0:
            temp = temp.next
            n -= 1

        if not temp:
            return head.next    
        
        start = head

        while temp.next:
            temp = temp.next
            start = start.next

        start.next = start.next.next    

        return head           
