class Solution 
{
    public String mergeAlternately(String word1, String word2) 
    {
        StringBuilder res=new StringBuilder();
        int l1=word1.length(),l2=word2.length(),i=0,j=0;
        while(i<l1 || j<l2)
        {
            if(i<l1)
                res.append(word1.charAt(i++));
            if(j<l2)
                res.append(word2.charAt(j++));
        }
        return res.toString();
    }
}

//Time Complexity : O(N)
//Space Complexity : O(1)
