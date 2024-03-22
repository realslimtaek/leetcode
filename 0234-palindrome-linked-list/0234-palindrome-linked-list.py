# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# class Solution(object):
#     def isPalindrome(self, head):
#         """
#         :type head: ListNode
#         :rtype: bool
#         """
        
class Solution(object):
    def isPalindrome(self, head):
        ans = []
        while head:
            ans.append(head.val)
            head = head.next

        return ans==list(reversed(ans))

        