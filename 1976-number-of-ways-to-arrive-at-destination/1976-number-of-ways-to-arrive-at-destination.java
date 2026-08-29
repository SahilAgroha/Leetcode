import java.util.*;

class Solution {

    class Edge {
        int dest;
        int time;

        Edge(int dest, int time) {
            this.dest = dest;
            this.time = time;
        }
    }

    public int countPaths(int n, int[][] roads) {

        List<Edge>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Undirected graph
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int time = road[2];

            graph[u].add(new Edge(v, time));
            graph[v].add(new Edge(u, time));
        }

        long[] dist = new long[n];
        long[] ways = new long[n];

        Arrays.fill(dist, Long.MAX_VALUE);

        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a[0], b[0])
        );

        // {distance, node}
        pq.offer(new long[]{0, 0});

        int MOD = 1_000_000_007;

        while (!pq.isEmpty()) {

            long[] curr = pq.poll();

            long currDist = curr[0];
            int node = (int) curr[1];

            // Skip outdated entry
            if (currDist > dist[node]) {
                continue;
            }

            for (Edge edge : graph[node]) {

                int next = edge.dest;

                long newDist = currDist + edge.time;

                // Found a shorter path
                if (newDist < dist[next]) {

                    dist[next] = newDist;

                    ways[next] = ways[node];

                    pq.offer(new long[]{
                        newDist,
                        next
                    });
                }

                // Found another shortest path
                else if (newDist == dist[next]) {

                    ways[next] =
                        (ways[next] + ways[node]) % MOD;
                }
            }
        }

        return (int) ways[n - 1];
    }
}