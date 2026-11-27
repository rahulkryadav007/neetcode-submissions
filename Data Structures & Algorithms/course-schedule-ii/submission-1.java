class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Calculate indegree
        int[] indegree = new int[numCourses];

        for (int[] p : prerequisites) {

            int a = p[0];
            int b = p[1];

            adj.get(b).add(a);

            indegree[a]++;
        }

        // Create queue
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {

            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // BFS
        int[] result = new int[numCourses];

        int index = 0;

        while (!queue.isEmpty()) {

            int course = queue.poll();

            result[index++] = course;

            for (int next : adj.get(course)) {

                indegree[next]--;

                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        // Check cycle
        if (index != numCourses) {
            return new int[0];
        }

        return result;
    }
}
