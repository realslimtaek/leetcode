class Solution(object):
    def searchInsert(self, nums, target):
        ans = 0
        for i in nums:
            if i >= target:
                return ans
            ans+= 1
        return ans