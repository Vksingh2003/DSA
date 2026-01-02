// class Solution {
//     public int[][] merge(int[][] intervals) {
// 		int min = Integer.MAX_VALUE;
// 		int max = Integer.MIN_VALUE;
		
// 		for (int i = 0; i < intervals.length; i++) {
// 			min = Math.min(min, intervals[i][0]);
// 			max = Math.max(max, intervals[i][0]);
// 		}
		
// 		int[] range = new int[max - min + 1];
// 		for (int i = 0; i < intervals.length; i++) {
// 			range[intervals[i][0] - min] = Math.max(intervals[i][1] - min, range[intervals[i][0] - min]); 
// 		}
		
// 		int start = 0, end = 0;
// 		LinkedList<int[]> result = new LinkedList<>();
// 		for (int i = 0; i < range.length; i++) {
// 			if (range[i] == 0) {
// 				continue;
// 			}
// 			if (i <= end) {
// 				end = Math.max(range[i], end);
// 			} else {
// 				result.add(new int[] {start + min, end + min});
// 				start = i;
// 				end = range[i];
// 			}
// 		}
// 		result.add(new int[] {start + min, end + min});
// 		return result.toArray(new int[result.size()][]);
// 	}


class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][0];

        // Step 1: Sort by start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> result = new ArrayList<>();

        int[] current = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] next = intervals[i];

            // Overlap case
            if (next[0] <= current[1]) {
                current[1] = Math.max(current[1], next[1]);
            } 
            // No overlap
            else {
                result.add(current);
                current = next;
            }
        }

        // Add last interval
        result.add(current);

        return result.toArray(new int[result.size()][]);
    }
}
