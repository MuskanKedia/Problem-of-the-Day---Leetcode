class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] pass = {1, 7, 30};
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return minCost(days, costs, pass, 0, dp);
    }
    
    public int minCost(int[] days, int[] costs, int[] pass, int ind, int[] dp) {
        if(ind == days.length) {
            return 0;
        }
        if(dp[ind] != -1) {
            return dp[ind];
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < costs.length; i++) {
            int c = costs[i];
            int d = pass[i];
            int j = ind;
            while(j < days.length && days[j] < days[ind] + d) {
                j++;
            }
            min = Math.min(min, c + minCost(days, costs, pass, j, dp));
        }
        return dp[ind] = min;
    }
}

//Time Complexity : O(n^2)
//Space Complexity : O(n)
