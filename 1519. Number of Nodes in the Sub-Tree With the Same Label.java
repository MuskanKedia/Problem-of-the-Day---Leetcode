class Solution {
    Map<Integer, List<Integer>> adjList;
    int[] ans;
    String labels;
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        adjList = new HashMap<>();
        ans = new int[n];
        this.labels = labels;
        for(int[] edge : edges){
            List<Integer> fromList = adjList.getOrDefault(edge[0], new ArrayList<>());
            fromList.add(edge[1]);
            adjList.put(edge[0], fromList);

            List<Integer> toList = adjList.getOrDefault(edge[1], new ArrayList<>());
            toList.add(edge[0]);
            adjList.put(edge[1], toList);
        }
        dfs(0, -1);
        return ans;
    }

    int[] dfs(int node, int parent){
        char ch = labels.charAt(node);
        int[] nodeCounts = new int[26];
        nodeCounts[ch - 'a'] = 1;
        
        if (!adjList.containsKey(node)){
            return nodeCounts;
        }
        
        for(Integer child : adjList.getOrDefault(node, new ArrayList<>())){
            if(child == parent){
                continue;
            }
            int[] childCounts = dfs(child, node);
            for (int i = 0; i < 26; i++) {
                nodeCounts[i] += childCounts[i];
            }
        }

        ans[node] = nodeCounts[ch - 'a'];

        return nodeCounts;
    }
}

//Time Complexity : O(n)
//Space Complexity : O(n)
