class Solution 
{
    public int strStr(String haystack, String needle) 
    {
        int p1=0,p2=0;
        int len1=haystack.length(),len2=needle.length();
        if(len2==0)
            return 0;
        while(p1<len1)
        {
            if(haystack.charAt(p1)==needle.charAt(p2))
                p2++;
            else
            {
                p1=p1-p2;
                p2=0;
            }
            p1++;
            if(p2==len2)
                return p1-len2;
        }
        return -1;
    }
}

//Time Complexity : O(len1)
//Space Complexity : O(1)
