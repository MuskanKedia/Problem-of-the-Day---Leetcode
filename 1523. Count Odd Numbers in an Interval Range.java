class Solution 
{
    public int countOdds(int low, int high) 
    {
        int count=0;
        if(low%2==0 && low+1<=high)
            low++;
        if(high%2==0 && high-1>=low)
            high--;
        if(low==high && low%2==1)
            return 1;
        if(low==high && low%2==0)
            return count;
        count=((high-low)/2)+1;
        return count;
    }
}

//Time Complexity : O(1)
//Space Complexity : O(1)
