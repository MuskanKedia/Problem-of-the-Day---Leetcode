class Solution 
{
    public boolean detectCapitalUse(String word) 
    {
        int n=word.length();
        int count=0;
        for(int i=0;i<n;i++)
        {
            if('Z'-word.charAt(i)>=0)
                count++;
        }
        return count==0||count==n||(count==1 && 'Z'-word.charAt(0)>=0);
    }
}

// Time Complexity : O(n) where n is length of the string
// Space Complexity : O(1)
