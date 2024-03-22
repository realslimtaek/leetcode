class Solution(object):
    def reverse(self, x):
        INT_MAX = 2**31 - 1
        INT_MIN = -2**31

        answer = 0
        
        minus = 1
        temp = x

        if x < 0 :
            minus *= -1
            temp *= -1
        answer = minus * int("".join(reversed(list(str(temp)))))

        if INT_MIN <= answer <= INT_MAX : return answer 
        else: return 0
        