class Solution {
    public int maximumDetonation(int[][] bombs){
        List<List<Integer>> g = IntStream.range(0, bombs.length).mapToObj(i -> new ArrayList<Integer>()).collect(Collectors.toList());
        for(int i = 0; i < bombs.length; i++)
            for(int j = 0; j < bombs.length; j++)
                if(i != j && detonates(i, j, bombs))
                    g.get(i).add(j);
        int r = 0;
        for(int i = 0; i < bombs.length; i++)
            r = Math.max(dfs(i, g, new boolean[bombs.length]), r);
        return r;
    }

    int dfs(int u, List<List<Integer>> g, boolean[] seen){
        seen[u] = true;
        return 1 + g.get(u).stream().filter(v -> !seen[v]).mapToInt(v -> dfs(v, g, seen)).sum();
    }

    boolean detonates(int i, int j, int[][] bombs){//true if i bomb detonates j bomb
        long x = bombs[j][0] - bombs[i][0], y = bombs[j][1] - bombs[i][1];
        return x * x + y * y <= (long) bombs[i][2] * bombs[i][2];
    }
}

//Time Complexity : O(N*N)
//Space Complexity : O(N)
