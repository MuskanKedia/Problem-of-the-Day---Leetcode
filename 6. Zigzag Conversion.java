class Solution 
{
    public String convert(String s, int numRows) 
    {
        if(numRows==1)
            return s;
        StringBuilder str=new StringBuilder();
        int diff=2*(numRows-1);
        for(int i=0;i<numRows;i++)
        {
            int j=i;
            int d=diff-2*i;
            while(j<s.length())
            {
                str=str.append(s.charAt(j));
                if(i>0 && i<numRows-1 && j+d<s.length())
                    str=str.append(s.charAt(j+d));
                j=j+diff;
            }
        }
        return str.toString();
    }
}

//Time Complexity : O(N)
//Space Complexity : O(N)
