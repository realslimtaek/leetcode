class Solution(object):
    

    def maxUniqueSplit(self, s):
        def backTracking(s, cnt, ans, tmp, answer):
            if cnt >= len(s): 
                return max(answer, len(ans))

            tmp += s[cnt]
            if tmp not in ans: 
                ans.append(tmp)
                answer = backTracking(s, cnt + 1, ans, "", answer)
                ans.pop()

            answer = backTracking(s, cnt + 1, ans, tmp, answer)
            return answer    
        return backTracking(s, 0, [], "", 0)
