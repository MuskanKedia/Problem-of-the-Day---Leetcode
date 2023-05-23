class KthLargest 
{
    Queue<Integer> q;
    int k;
    public KthLargest(int k, int[] nums) 
    {
        this.k=k;
        q=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++)
            add(nums[i]);
    }
    
    public int add(int val)
    {
        q.add(val);
        if(q.size()>k)
            q.poll();
        return q.peek();
    }
}

//Time Complexity : O(logk)
//Space Complexity : O(k)
