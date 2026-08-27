class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;

        List<Integer>[] reverse = new ArrayList[n];
        int[] outdegree = new int[n];

        for (int i = 0; i < n; i++) {
            reverse[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {

            outdegree[i] = graph[i].length;

            for (int next : graph[i]) {
                reverse[next].add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();

        // Terminal nodes
        for (int i = 0; i < n; i++) {
            if (outdegree[i] == 0) {
                q.offer(i);
            }
        }

        boolean[] safe = new boolean[n];

        while (!q.isEmpty()) {

            int curr = q.poll();
            safe[curr] = true;

            for (int prev : reverse[curr]) {

                outdegree[prev]--;

                if (outdegree[prev] == 0) {
                    q.offer(prev);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (safe[i]) {
                ans.add(i);
            }
        }

        return ans;
    }
}