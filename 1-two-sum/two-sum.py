
class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        arr = [(num, i) for i, num in enumerate(nums)]
        arr.sort()

        left = 0
        right = len(arr) - 1

        while left < right:
            total = arr[left][0] + arr[right][0]

            if total < target:
                left += 1
            elif total > target:
                right -= 1
            else:
                return [arr[left][1], arr[right][1]]

        return []
