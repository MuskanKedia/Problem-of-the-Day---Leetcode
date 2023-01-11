class Solution 
{
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) 
    {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<Integer>());
        for(int[] edge:edges)
        {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        return helper(0,adj,hasApple,0);
    }
    public int helper(int index, List<List<Integer>> adj, List<Boolean> hasApple, int parent)
    {
        int total=0;
        for(int i:adj.get(index))
        {
            if(i==parent)
                continue;
            total+=helper(i,adj,hasApple,index);
        }
        if(index!=0 && (total>0 || hasApple.get(index)))
            total+=2;
        return total;
    }
}

//Time Complexity : O(n)
//Space Complexity : O(n)
