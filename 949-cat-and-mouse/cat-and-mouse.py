from collections import deque

class Solution:
    def catMouseGame(self, graph: list[list[int]]) -> int:
        n = len(graph)
        deg = [[[0]*2 for _ in range(n)] for __ in range(n)]
        result = [[[0]*2 for _ in range(n)] for __ in range(n)]
        for m in range(n):
            for c in range(n):
                deg[m][c][0] = len(graph[m])
                deg[m][c][1] = sum(1 for v in graph[c] if v != 0)
        q = deque()
        for c in range(n):
            for t in range(2):
                result[0][c][t] = 1
                q.append((0, c, t, 1))
        for i in range(1, n):
            for t in range(2):
                result[i][i][t] = 2
                q.append((i, i, t, 2))
        while q:
            m, c, t, win = q.popleft()
            pt = 1 - t
            if pt == 0:
                for pm in graph[m]:
                    if result[pm][c][pt] != 0:
                        continue
                    if win == 1:
                        result[pm][c][pt] = 1
                        q.append((pm, c, pt, 1))
                    else:
                        deg[pm][c][pt] -= 1
                        if deg[pm][c][pt] == 0:
                            result[pm][c][pt] = 2
                            q.append((pm, c, pt, 2))
            else:
                for pc in graph[c]:
                    if pc == 0:
                        continue
                    if result[m][pc][pt] != 0:
                        continue
                    if win == 2:
                        result[m][pc][pt] = 2
                        q.append((m, pc, pt, 2))
                    else:
                        deg[m][pc][pt] -= 1
                        if deg[m][pc][pt] == 0:
                            result[m][pc][pt] = 1
                            q.append((m, pc, pt, 1))
        return result[1][2][0]