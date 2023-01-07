class Solution 
{
    public int canCompleteCircuit(int[] gas, int[] cost) 
    {
        int n=gas.length;
        int temp=0,res=0,start=0;
        for(int i=0;i<n;i++)
        {
            res+=gas[i]-cost[i];
            temp+=gas[i]-cost[i];
            if(res<0)
            {
                res=0;
                start=i+1;
            }
        }
        return (temp<0)?-1:start;
    }
}

//Time Complexity : O(n)
//Space Complexity : O(1)
