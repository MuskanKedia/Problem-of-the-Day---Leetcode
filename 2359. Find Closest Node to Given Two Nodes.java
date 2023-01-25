class Solution 
{
    public int closestMeetingNode(int[] edges, int node1, int node2) 
    {
        int n=edges.length;
        int ans=-1,min=Integer.MAX_VALUE;
        int[] dist1=new int[n];
        int[] dist2=new int[n];
        boolean[] vis1=new boolean[n];
        boolean[] vis2=new boolean[n];
        dfs(node1,edges,dist1,vis1);
        dfs(node2,edges,dist2,vis2);
        for(int i=0;i<n;i++)
        {
            if(vis1[i] && vis2[i] && min>(Math.max(dist1[i],dist2[i])))
            {
                min=Math.max(dist1[i],dist2[i]);
                ans=i;
            }
        }
        return ans;
    }
    public void dfs(int node,int[] edges,int[] dist,boolean[] vis)
    {
        vis[node]=true;
        int val=edges[node];
        if(val!=-1 && !vis[val])
        {
            dist[val]=dist[node]+1;
            dfs(val,edges,dist,vis);
        }
    }
}

//Time Complexity : O(N)
//Space Complexity : O(N)
