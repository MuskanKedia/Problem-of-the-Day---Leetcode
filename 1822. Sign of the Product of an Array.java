class Solution {
    public int arraySign(int[] nums) {
        double product=1;
        for(int a:nums)
            product=product*a;
        if(product>0)
            return 1;
        else if(product<0)
            return -1;
        return 0;
    }
}

//Time Complexity : O(N)
//Space Complexity : O(1)
