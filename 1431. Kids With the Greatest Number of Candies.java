class Solution 
{
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) 
    {
        int max=0;
        for(int candy:candies)
            max=Math.max(max,candy);
        ArrayList<Boolean> list=new ArrayList<>();
        for(int candy:candies)
        {
            if(candy+extraCandies >= max)
                list.add(true);
            else
                list.add(false);
        }
        return list;
    }
}

//Time Complexity : O(N)
//Space Complexity : O(1)
