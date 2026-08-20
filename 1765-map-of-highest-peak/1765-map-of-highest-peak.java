class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;

        Queue<int[]> q = new LinkedList<>();

        // height = -1 means unvisited
        int[][] height = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(height[i], -1);

            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    height[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }

        int[][] dir = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];

            for (int[] d : dir) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < m &&
                    nc >= 0 && nc < n &&
                    height[nr][nc] == -1) {

                    height[nr][nc] = height[r][c] + 1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        return height;
    }
}