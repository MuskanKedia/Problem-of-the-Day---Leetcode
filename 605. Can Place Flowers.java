class Solution 
{
    public boolean canPlaceFlowers(int[] flowerbed, int n) 
    {
        int T=0;
        for(int i=0;i<flowerbed.length && T<n;i++)
        {
            if(flowerbed[i]==0)
            {
                int next=(i==flowerbed.length-1)?0:flowerbed[i+1];
                int prev=(i==0)?0:flowerbed[i-1];
                if(next==0 && prev==0)
                {
                    flowerbed[i]=1;
                    T++;
                }
            }
        }
        if(T>=n)
            return true;
        return false;
    }
}

//Time Complexity : O(N)
//Space Complexity : O(1)
