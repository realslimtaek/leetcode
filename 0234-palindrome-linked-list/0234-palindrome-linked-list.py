class Solution(object):
    def isPalindrome(self, head):
        ans = []
        while head:
            ans.append(head.val)
            head = head.next

        return ans==list(reversed(ans))

        