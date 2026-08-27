import java.util.*;

class Solution {

    public int[] sortItems(int n, int m, int[] group,List<List<Integer>> beforeItems) {

        // Step 1: Give unique groups to ungrouped items
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = m++;
            }
        }

        // Graphs
        List<Integer>[] itemGraph = new ArrayList[n];
        List<Integer>[] groupGraph = new ArrayList[m];

        for (int i = 0; i < n; i++) {
            itemGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            groupGraph[i] = new ArrayList<>();
        }

        int[] itemIndegree = new int[n];
        int[] groupIndegree = new int[m];

        // Step 2: Build graphs
        for (int i = 0; i < n; i++) {

            for (int prev : beforeItems.get(i)) {

                // Item dependency
                itemGraph[prev].add(i);
                itemIndegree[i]++;

                // Group dependency
                int prevGroup = group[prev];
                int currGroup = group[i];

                if (prevGroup != currGroup) {
                    groupGraph[prevGroup].add(currGroup);
                    groupIndegree[currGroup]++;
                }
            }
        }

        // Step 3: Topological sort groups
        List<Integer> groupOrder =
                topoSort(groupGraph, groupIndegree, m);

        if (groupOrder.size() != m) {
            return new int[0];
        }

        // Step 4: Topological sort items
        List<Integer> itemOrder =
                topoSort(itemGraph, itemIndegree, n);

        if (itemOrder.size() != n) {
            return new int[0];
        }

        // Step 5: Put items inside their groups
        List<Integer>[] groupedItems = new ArrayList[m];

        for (int i = 0; i < m; i++) {
            groupedItems[i] = new ArrayList<>();
        }

        for (int item : itemOrder) {
            groupedItems[group[item]].add(item);
        }

        // Step 6: Create final answer
        int[] ans = new int[n];
        int index = 0;

        for (int g : groupOrder) {
            for (int item : groupedItems[g]) {
                ans[index++] = item;
            }
        }

        return ans;
    }


    private List<Integer> topoSort(
            List<Integer>[] graph,
            int[] indegree,
            int n) {

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        List<Integer> order = new ArrayList<>();

        while (!q.isEmpty()) {

            int curr = q.poll();
            order.add(curr);

            for (int next : graph[curr]) {

                indegree[next]--;

                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        return order;
    }
}