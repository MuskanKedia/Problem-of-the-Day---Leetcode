class Solution 
{
    public int subarraysDivByK(int[] nums, int k) 
    {
        int[] temp=new int[k];
        temp[0]=1;
        int count=0,sum=0;
        for(int a:nums)
        {
            sum=(sum+a)%k;
            if(sum<0)
                sum=sum+k;
            count=count+temp[sum];
            temp[sum]++;
        }
        return count;
    }
}

//Time Complexity : O(N)
//Space Complexity : O(k)
