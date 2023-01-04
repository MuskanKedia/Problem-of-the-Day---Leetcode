class Solution 
{
    public int minimumRounds(int[] tasks) 
    {
        int res=0;
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int n:tasks)
            map.put(n,map.getOrDefault(n,0)+1);
        for(int val:map.values())
        {
            if(val==1)
                return -1;
            res+=(val+2)/3;
        }
        return res;
    }
}

//Time Complexity : O(N)
//Space Complexity : O(N)
