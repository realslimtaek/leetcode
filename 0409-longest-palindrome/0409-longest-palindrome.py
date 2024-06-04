class Solution(object):
    def longestPalindrome(self, s):
        
        
        n = Counter(s)
        ans = 0
        flag = True
        for i in n:
            ans += int(n[i] // 2) * 2
            if flag and n[i] % 2 == 1:
                ans += 1
                flag = False

        return ans