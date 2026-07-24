class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // ajacent list
        int[] indegree = new int[numCourses];
        int[][] list = new int[numCourses][numCourses];
        Queue<Integer> queue = new LinkedList<>();
        int cantake = 0;

        for (int[] pre : prerequisites) {
            list[pre[1]][pre[0]] = 1;
            indegree[pre[0]]++;
        }

        // indegree 0 means we can take the course
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }
        // indegree for each nodes

        while (!queue.isEmpty()) {
            int node = queue.poll();
            int[] neighbous = list[node];

            // travse its neighbous
            for (int i = 0; i < neighbous.length; i++) {
                if (neighbous[i] == 1) {
                    indegree[i] --;
                    if (indegree[i] == 0) {
                        queue.add(i);
                    }
                }
            }

            cantake++;
        }

        return cantake == numCourses;

    }
}