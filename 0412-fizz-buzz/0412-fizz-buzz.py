class Solution(object):
    def fizzBuzz(self, n):
        li = [str(i) for i in range(1,n+1)]
        for i in range(2,len(li),3):
            li[i] = "Fizz"
        for i in range(4,len(li),5):
            li[i] = "Buzz"
        for i in range(14,len(li),15):
            li[i] = "FizzBuzz"
            
        return li
        