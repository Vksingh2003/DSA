class Solution(object):
    def cherryPickup(self, grid):
        n = len(grid)

        dp = [[[float('-inf')]*n for _ in range(n)] for _ in range(n)]
        dp[0][0][0] = 0

        for x1 in range(n):
            for y1 in range(n):
                for x2 in range(n):
                    y2 = x1 + y1 - x2
                    if not (0<= y2 < n):
                        continue
                    if grid[x1][y1] == -1 or grid[x2][y2] == -1:
                        continue
                    
                    if x1 > 0 and x2 > 0:
                        dp[x1][y1][x2] = max(dp[x1][y1][x2], dp[x1-1][y1][x2-1])
                    if y1 > 0 and x2 > 0:
                        dp[x1][y1][x2] = max(dp[x1][y1][x2], dp[x1][y1-1][x2-1])
                    if x1 > 0:
                        dp[x1][y1][x2] = max(dp[x1][y1][x2], dp[x1-1][y1][x2])
                    if y1 > 0:
                        dp[x1][y1][x2] = max(dp[x1][y1][x2], dp[x1][y1-1][x2])
                    
                    if x1 == x2 and y1 == y2:
                        dp[x1][y1][x2] += grid[x1][y1]
                    else:
                        dp[x1][y1][x2] += grid[x1][y1] + grid[x2][y2]
        
        return max(0 ,dp[n-1][n-1][n-1])