class Solution {
    public int maxProfit(int[] A) 
    {
        int profit=0,min=Integer.MAX_VALUE;
        for(int i=0;i<A.length;i++)
        {
            if(A[i]<min)
                min=A[i];
            if(A[i]-min>profit)
                profit=A[i]-min;
        }
        return profit;
    }
}

//Time Complexity : O(N)
//Space Complexity : O(1)
