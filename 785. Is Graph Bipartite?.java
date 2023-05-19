class Solution 
{
    public boolean isBipartite(int[][] graph)
    {  
        int V=graph.length;
        int color[]=new int[V];
        for(int i=0;i<V;i++)
            color[i]=-1;
        for(int i=0;i<V;i++)
        {
            if(color[i]==-1)
            {
                if(!dfs(i,graph,color))
                    return false;
            }
        }
        return true;
    }
    public boolean dfs(int i,int[][] graph,int[] color)
    {
        for(int it:graph[i])
        {
            if(color[it]==-1)
            {
                color[it]=1-color[i];
                if(!dfs(it,graph,color))
                    return false;
            }
            else if(color[it]==color[i])
                return false;
        }
        return true;
    }
}

//Time Complexity : O(V+E)
//Space Complexity : O(V)
