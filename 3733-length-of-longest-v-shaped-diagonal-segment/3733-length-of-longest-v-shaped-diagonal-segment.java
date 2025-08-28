class Solution {
   
    public int lenOfVDiagonal(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    // 여기서 나아갈 방향이 한 곳 이라도 있는지 확인
                    int temp = check(i, j, grid, 1, 1, Direction.start, false);
                    ans = Math.max(ans, temp);
                }
            }
        }

        return ans;
    }

    public static int check(int x, int y, int[][] grid, int bef, int count, Direction direction, boolean turned) {
        // 경계 조건
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) return count - 1;
        if (count > 1 && grid[x][y] == 1) return count - 1;
        if (count == 2 && grid[x][y] == 0) return count - 1;
        if (count > 1 && grid[x][y] == bef) return count - 1;

        int maxCount = count;

        switch (direction) {
            case start -> {
                maxCount = Math.max(maxCount,
                        Math.max(
                                check(x - 1, y - 1, grid, grid[x][y], count + 1, Direction.leftUp, false),
                                Math.max(
                                        check(x - 1, y + 1, grid, grid[x][y], count + 1, Direction.rightUP, false),
                                        Math.max(
                                                check(x + 1, y + 1, grid, grid[x][y], count + 1, Direction.rightDown, false),
                                                check(x + 1, y - 1, grid, grid[x][y], count + 1, Direction.leftDown, false)
                                        )
                                )
                        )
                );
            }
            case leftUp -> {
                maxCount = turned ? check(x - 1, y - 1, grid, grid[x][y], count + 1, Direction.leftUp, true)
                        : Math.max(
                        check(x - 1, y - 1, grid, grid[x][y], count + 1, Direction.leftUp, false),
                        check(x - 1, y + 1, grid, grid[x][y], count + 1, Direction.rightUP, true)
                );
            }
            case leftDown -> {
                maxCount = turned ? check(x + 1, y - 1, grid, grid[x][y], count + 1, Direction.leftDown, true)
                        : Math.max(
                        check(x + 1, y - 1, grid, grid[x][y], count + 1, Direction.leftDown, false),
                        check(x - 1, y - 1, grid, grid[x][y], count + 1, Direction.leftUp, true)
                );
            }
            case rightUP -> {
                maxCount = turned ? check(x - 1, y + 1, grid, grid[x][y], count + 1, Direction.rightUP, true)
                        : Math.max(
                        check(x - 1, y + 1, grid, grid[x][y], count + 1, Direction.rightUP, false),
                        check(x + 1, y + 1, grid, grid[x][y], count + 1, Direction.rightDown, true)
                );
            }
            case rightDown -> {
                maxCount = turned ? check(x + 1, y + 1, grid, grid[x][y], count + 1, Direction.rightDown, true)
                        : Math.max(
                        check(x + 1, y + 1, grid, grid[x][y], count + 1, Direction.rightDown, false),
                        check(x + 1, y - 1, grid, grid[x][y], count + 1, Direction.leftDown, true)
                );
            }
        }

        return maxCount;
    }


    public enum Direction {
        leftUp, rightUP, rightDown, leftDown, start
    }
}
