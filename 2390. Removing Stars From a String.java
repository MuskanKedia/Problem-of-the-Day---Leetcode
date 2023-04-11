class Solution 
{
    public String removeStars(String s) 
    {
        StringBuilder str=new StringBuilder();
        for(char ch:s.toCharArray())
        {
            if(ch=='*')
                str.deleteCharAt(str.length()-1);
            else
                str.append(ch);
        }
        return str.toString();
    }
}

//Time Complexity : O(N)
//Space Complexity : O(1)
