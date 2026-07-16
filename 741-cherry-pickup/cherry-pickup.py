class Solution:
    def cherryPickup(self, grid: List[List[int]]) -> int:
        n = len(grid)

        @cache
        def dfs(k, r1, r2):
            c1 = k - r1
            c2 = k - r2

            if r1 >= n or r2 >= n or c1 >= n or c2 >= n or grid[r1][c1] == -1 or grid[r2][c2] == -1:
                return -inf
            if r1 == n - 1 and c1 == n - 1:
                return grid[r1][c1]

            if r1 != r2 or c1 != c2:
                score = grid[r1][c1] + grid[r2][c2]
            else:
                score = grid[r1][c1]

            right_right = dfs(k + 1, r1, r2)
            right_down = dfs(k + 1, r1, r2 + 1)
            down_right = dfs(k + 1, r1 + 1, r2)
            down_down = dfs(k + 1, r1 + 1, r2 + 1)

            return score + max(right_right, right_down, down_right, down_down)

        res = dfs(0, 0, 0)
        return res if res >= 0 else 0