class Solution 
{
    public boolean isAlienSorted(String[] words, String order) 
    {
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<order.length();i++)
            map.put(order.charAt(i),i);
        for(int i=0;i<words.length-1;i++)
        {
            int j=0;
            while(j<words[i].length() && j<words[i+1].length())
            {
                if(map.get(words[i].charAt(j))==map.get(words[i+1].charAt(j)))
                    j++;
                else if(map.get(words[i].charAt(j))>map.get(words[i+1].charAt(j)))
                    return false;
                else if(map.get(words[i].charAt(j))<map.get(words[i+1].charAt(j)))
                    break;
            }
            if(j==words[i+1].length() && j<words[i].length())
                return false;
        }
        return true;
    }
}

//Time Complexity : O(N)
//Space Complexity : O(N)
