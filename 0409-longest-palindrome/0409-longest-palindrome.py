class Solution(object):
    def longestPalindrome(self, s):
        
        n = [0,0]
        
        
        for k in s:
            n[1] += s.count(k) // 2
            n[0] += s.count(k) % 2
            s = [i for i in s if i not in k]
        ans = int(n[1]) * 2
        
        if n[0] != 0 : 
            ans += 1
            
        return ans