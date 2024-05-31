class Solution(object):
    def singleNumber(self, nums):
        ans = []
        for n in nums:
            if nums.count(n) == 1:
                ans.append(n)
                
        return ans
            
            
        