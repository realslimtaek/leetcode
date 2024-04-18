class Solution(object):
    def islandPerimeter(self, grid):
        length = len(grid)
        ans = 0
        for i in range(len(grid)):
            for j in range(len(grid[i])):
                count = 4
                if(grid[i][j] == 0):
                    continue
                else :
                    print(i,j)
                    if(i > 0 and grid[i-1][j] == 1):
                        count -= 1
                    if(i < length-1 and grid[i+1][j] == 1):
                        count -= 1
                    if(j > 0 and grid[i][j-1] == 1):
                        count -= 1
                    if(j < len(grid[i])-1 and grid[i][j+1] == 1):
                        count -= 1
                    ans += count
                    
        return ans