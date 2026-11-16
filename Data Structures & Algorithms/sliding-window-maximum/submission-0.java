class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> dq = new ArrayDeque<>();

        int n = nums.length;
        int[] result = new int[n - k + 1];

        for (int i = 0; i < n; i++) {

            // Remove elements outside the window
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // Remove smaller elements from the back
            while (!dq.isEmpty() &&
                   nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            // Add current index
            dq.offerLast(i);

            // Store maximum when window size becomes k
            if (i >= k - 1) {
                result[i - k + 1] = nums[dq.peekFirst()];
            }
        }

        return result;
    }
}
