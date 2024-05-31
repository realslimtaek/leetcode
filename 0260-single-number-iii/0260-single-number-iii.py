class Solution(object):
    def singleNumber(self, nums):
        for n in nums:
            if nums.count(n) > 1:
                nums = [i for i in nums if i != n]
                
        return nums
            
            
        