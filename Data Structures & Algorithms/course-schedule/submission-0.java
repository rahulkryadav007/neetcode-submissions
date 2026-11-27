class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // Step 1: Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Step 2: Calculate indegree
        int[] indegree = new int[numCourses];

        for (int[] p : prerequisites) {

            int a = p[0];
            int b = p[1];

            adj.get(b).add(a);

            indegree[a]++;
        }

        // Step 3: Add courses with indegree 0
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {

            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Step 4: BFS
        int count = 0;

        while (!queue.isEmpty()) {

            int course = queue.poll();

            count++;

            for (int next : adj.get(course)) {

                indegree[next]--;

                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // Step 5: Check cycle
        return count == numCourses;
    }
}
