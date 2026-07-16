class Solution:
    def generate(self, numRows: int):
        result = []

        for i in range(numRows):

            row = [1]

            if i > 0:

                prev = result[i - 1]

                for j in range(1, i):
                    row.append(prev[j - 1] + prev[j])

                row.append(1)

            result.append(row)

        return result