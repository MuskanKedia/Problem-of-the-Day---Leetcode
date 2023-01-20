class Solution 
{
    public List<List<Integer>> findSubsequences(int[] nums) 
    {
        List<List<Integer>> ans=new ArrayList<>();
        helper(0,nums,ans,new ArrayList<>());
        return ans;
    }
    public void helper(int i,int[] nums,List<List<Integer>> ans,List<Integer> temp)
    {
        if(i>nums.length-1)
        {
            if(temp.size()>1)
                ans.add(new ArrayList<>(temp));
            return;
        }
        if(temp.isEmpty() || nums[i]>=temp.get(temp.size()-1))
        {
            temp.add(nums[i]);
            helper(i+1,nums,ans,temp);
            temp.remove(temp.size()-1);
        }
        if(i>0 && temp.size()>0 && nums[i]==temp.get(temp.size()-1))
            return;
        helper(i+1,nums,ans,temp);
    }
}

//Time Complexity : O(N * 2^N)
//Space Complexity : O(N)
