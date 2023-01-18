class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int tsum=0,sum1=0,sum2=0,max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        for(int a:nums)
        {
            tsum+=a;
            sum1+=a;
            sum2+=a;
            max=Math.max(sum1,max);
            if(sum1<0)
                sum1=0;
            min=Math.min(min,sum2);
            if(sum2>0)
                sum2=0;
        }
        if(tsum==min)
            return max;
        return Math.max(max,tsum-min);
    }
}

//Time Complexity : O(N)
//Space Complexity : O(1)
