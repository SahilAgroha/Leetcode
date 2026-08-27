/*
Intuition
---------
This problem requires satisfying two different dependency orders:

1. Item dependencies
   - If item A must come before item B, then A should appear before B.

2. Group dependencies
   - If an item in group X depends on an item in group Y,
     then every item of group Y must appear before any item of group X.

Instead of building two completely separate topological orders,
we process them simultaneously.

-------------------------------------------------------------
Observation 1
-------------------------------------------------------------
Each group can only be processed after all incoming dependencies
from OTHER groups have been resolved.

For this, we maintain:

gInDegree[group]

which represents the number of remaining cross-group dependencies
entering that group.

Initially, every group whose gInDegree is 0 is ready to be processed,
so we push it into a group queue.

-------------------------------------------------------------
Observation 2
-------------------------------------------------------------
Once a group becomes available, we only care about ordering
the items INSIDE that group.

For every group popped from the group queue:

- Start a normal Kahn's Topological Sort.
- Initially insert every item in that group whose item indegree is 0.
- Process items until the group's queue becomes empty.

-------------------------------------------------------------
How dependencies are updated
-------------------------------------------------------------
Suppose we process item u.

For every edge

u -> v

we always decrease

itemIndegree[v]

because one prerequisite of v has now been completed.

There are two cases:

1. Same group
--------------
If u and v belong to the same group,
then v may immediately become available.

So if

itemIndegree[v] == 0

push v into the current item's queue.

2. Different groups
-------------------
If u and v belong to different groups,
then we've satisfied one cross-group dependency.

So decrease

groupIndegree[group(v)]

When it becomes zero,
that entire group is now ready,
so push it into the group queue.

Notice that we DO NOT immediately push item v.
Even if its item indegree becomes zero,
its group still has to wait until all cross-group dependencies
have been resolved.

-------------------------------------------------------------
Why this works
-------------------------------------------------------------
Every dependency is handled exactly once.

For every processed edge:

- item indegree is decreased.
- if it is a cross-group edge,
  group indegree is also decreased.

A group only enters the group queue after every incoming
cross-group dependency has been processed.

Once a group starts processing,
a standard topological sort guarantees that every item inside
that group is produced in a valid order.

Thus:

- group ordering is respected
- item ordering inside every group is respected

-------------------------------------------------------------
Complexity
-------------------------------------------------------------
Let

n = number of items
e = number of dependencies

Building the graph:
O(n + e)

Each item is processed once.
Each dependency is processed once.

Total Time:
O(n + e)

Space:
O(n + e)
*/
class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
       
        List<Integer> groupItems[] = new ArrayList[n];
        List<Integer> childItems[] = new ArrayList[n];
        int inDegree[] = new int[n];
        int gInDegree[] = new int[n];

        for(int i=0;i<n;i++){
            childItems[i] = new ArrayList<>();
            groupItems[i] = new ArrayList<>();
        }   

        int uniqueGroupID = n-1;
        for(int i=0;i<n;i++){
            if(group[i] == -1){
                groupItems[uniqueGroupID].add(i);
                group[i] = uniqueGroupID--;
            }
            else{
                groupItems[group[i]].add(i);
            }
        }

        for(int i=0;i<n;i++){
            for(int p : beforeItems.get(i)){
                childItems[p].add(i);
                inDegree[i]++;

                if(group[p] != group[i]){
                    gInDegree[group[i]]++;
                }
            }
        }

        int res[] = new int[n];
        int ind = 0;
        Queue<Integer> groupQ = new LinkedList<>();

        for(int i=0;i<n;i++){
            if(gInDegree[i] == 0)
                groupQ.offer(i);
        }

        while(!groupQ.isEmpty()){

            int gId = groupQ.poll();

            Queue<Integer> q = new LinkedList<>();

            for(int i : groupItems[gId]){
                if(inDegree[i] == 0)
                    q.offer(i);
            }

            while(!q.isEmpty()){
                int p = q.poll();

                res[ind++] = p;

                for(int c : childItems[p]){
                    inDegree[c]--;

                    if(group[p] != group[c]){
                        if(--gInDegree[group[c]] == 0)
                            groupQ.offer(group[c]);
                    }
                    else if(inDegree[c] == 0)
                        q.offer(c);
                }
            }

        }

        return ind == n ? res : new int[0];

    }
}