class Solution 
{
    public int minFlipsMonoIncr(String s) 
    {
        int c0=0,c1=0,count=s.length();
        for(int i=0;i<s.length();i++)
            if(s.charAt(i)=='0')
                c0++;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='0')
                c0--;
            count=Math.min(count,c0+c1);
            if(s.charAt(i)=='1')
                c1++;
        }
        return count;
    }
}

//Time Complexity : O(N)
//Space Complexity : O(1)
