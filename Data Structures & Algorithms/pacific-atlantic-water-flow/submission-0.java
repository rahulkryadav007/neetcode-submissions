
class Solution {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // Pacific: Top and Left borders
        // Atlantic: Bottom and Right borders

        for (int i = 0; i < m; i++) {

            dfs(heights, i, 0, pacific, Integer.MIN_VALUE);

            dfs(heights, i, n - 1, atlantic, Integer.MIN_VALUE);
        }

        for (int j = 0; j < n; j++) {

            dfs(heights, 0, j, pacific, Integer.MIN_VALUE);

            dfs(heights, m - 1, j, atlantic, Integer.MIN_VALUE);
        }

        List<List<Integer>> result = new ArrayList<>();

        // Find cells that can reach both oceans
        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (pacific[i][j] && atlantic[i][j]) {

                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, int r, int c,
                     boolean[][] visited, int prevHeight) {

        int m = heights.length;
        int n = heights[0].length;

        // Boundary check
        if (r < 0 || c < 0 || r >= m || c >= n) {
            return;
        }

        // Already visited or height is smaller
        if (visited[r][c] || heights[r][c] < prevHeight) {
            return;
        }

        visited[r][c] = true;

        // Four directions
        dfs(heights, r - 1, c, visited, heights[r][c]);

        dfs(heights, r + 1, c, visited, heights[r][c]);

        dfs(heights, r, c - 1, visited, heights[r][c]);

        dfs(heights, r, c + 1, visited, heights[r][c]);
    }
}
