class Solution {
    public void islandsAndTreasure(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // Step 1: Add all treasure chests to queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        // Four directions: up, down, left, right
        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        // Step 2: BFS
        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];

            for (int[] dir : directions) {

                int newRow = row + dir[0];
                int newCol = col + dir[1];

                // Check boundaries and unvisited land
                if (newRow >= 0 && newRow < m &&
                    newCol >= 0 && newCol < n &&
                    grid[newRow][newCol] == 2147483647) {

                    grid[newRow][newCol] = grid[row][col] + 1;

                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
    }
}
