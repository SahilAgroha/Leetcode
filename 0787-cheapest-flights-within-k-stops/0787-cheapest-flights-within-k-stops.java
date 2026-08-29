class Solution {
    public int findCheapestPrice(
            int n, int[][] flights,
            int src, int dst, int k) {

        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);

        cost[src] = 0;

        // At most k stops = k + 1 edges
        for (int i = 0; i <= k; i++) {

            int[] temp = cost.clone();

            for (int[] flight : flights) {

                int u = flight[0];
                int v = flight[1];
                int price = flight[2];

                if (cost[u] != Integer.MAX_VALUE) {
                    temp[v] = Math.min(
                        temp[v],
                        cost[u] + price
                    );
                }
            }

            cost = temp;
        }

        return cost[dst] == Integer.MAX_VALUE
                ? -1
                : cost[dst];
    }
}