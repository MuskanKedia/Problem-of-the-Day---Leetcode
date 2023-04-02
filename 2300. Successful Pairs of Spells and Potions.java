class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) 
    {
        int [] res = new int[spells.length];
        
        Arrays.sort(potions);
        
        for(int s=0;s<spells.length;s++)
        {
            res[s] = binarySearch((long) spells[s],potions,success);
        }
        
        return res;
    }
    
    public static int binarySearch(long s, int [] arr, long success)
    {
        if(success > s*(long)arr[arr.length-1])
        {
            return 0;
        }
        else if(success <= s*(long)arr[0])
        {
            return arr.length;
        }
        int l=0;
        int r=arr.length-1;
        
        while(l<r)
        {
            int m = l + (r-l)/2;
            
            // potion + spell below success keep
            if(s*(long)arr[m] < success)
            {
              l=m+1;
            }
            // potion + spell above success ignore
            else if(s*(long)arr[m] > success)
            {
               r=m;
            }
            // equal find last index
            else
            {
                int c=m;
                while(c >=0 && s*(long)arr[c]==success)
                {
                    c--;
                }
                return arr.length-1-c;
            }
        }
        return arr.length-r;
    }
}

//Time Complexity : O(nlogm)
//Space Complexity : O(1)
