class Solution {
    public List<List<String>> partition(String s) 
    {
        List<List<String>> res=new ArrayList<>();
        List<String> temp=new ArrayList<>();
        func(0,s,temp,res);
        return res;
    }
    public void func(int ind,String s,List<String> temp,List<List<String>> res)
    {
        if(ind==s.length())
        {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i=ind;i<s.length();i++)
        {
            if(isPalin(s,ind,i))
            {
                temp.add(s.substring(ind,i+1));
                func(i+1,s,temp,res);
                temp.remove(temp.size()-1);
            }
        }
    }
    public boolean isPalin(String s,int i,int j)
    {
        while(i<=j)
        {
            if(s.charAt(i++)!=s.charAt(j--))
                return false;
        }
        return true;
    }
}

//Time Complexity : O(n!)
//Space Complexity : O(nxk) where n= avg length of each partitioned array and k = total no of arrays
