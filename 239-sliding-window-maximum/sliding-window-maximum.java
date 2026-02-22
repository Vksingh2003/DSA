import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int ans[] = new int[n - k + 1];

        // max heap (value, index)
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]
        );

        int idx = 0;

        for (int i = 0; i < n; i++) {

            // add element
            pq.offer(new int[]{nums[i], i});

            // remove elements out of window
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }

            // store answer when window is ready
            if (i >= k - 1) {
                ans[idx++] = pq.peek()[0];
            }
        }

        return ans;
    }
}