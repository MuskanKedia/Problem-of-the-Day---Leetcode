class Solution 
{
    public int[] topKFrequent(int[] nums, int k) 
    {
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int a:nums)
            map.put(a,map.getOrDefault(a,0)+1);
        PriorityQueue<Map.Entry<Integer,Integer>> pq=new PriorityQueue<>((a,b)->(a.getValue()-b.getValue()));
        for(Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            pq.add(entry);
            while(pq.size()>k)
                pq.poll();
        }
        int[] res=new int[k];
        int i=0;
        while(!pq.isEmpty())
            res[i++]=pq.poll().getKey();
        return res;
    }
}

//Time Complexity : O(nlogk)
//Space Complexity : O(n)
