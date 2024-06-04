class Solution(object):
    def longestPalindrome(self, s):
        
        n = {}
        
        for k in s:
            if k in n:
                n[k] += 1
            else : 
                n[k] = 1

        ans = 0
        flag = True
        for i in n:
            ans += int(n[i] // 2) * 2
            if flag == True and n[i] % 2 == 1:
                ans += 1
                flag = False

        return ans