class Solution 
{
    public boolean wordPattern(String pattern, String s) 
    {
        String[] str=s.split(" ");
        HashMap map=new HashMap();
        if(pattern.length()!=str.length)
            return false;
        for(Integer i=0;i<str.length;i++)
        {
            if(map.put(pattern.charAt(i),i)!=map.put(str[i],i))
                return false;
        }
        return true;
    }
}

//Time Complexity : O(n) where n is length of pattern
//Space Complexity : O(n) where n is length of pattern used for hashmap
