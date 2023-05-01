class Solution {
    public double average(int[] salary) {
        if(salary.length<=2)
            return 0;
        double sum=0;
        double min=Integer.MAX_VALUE;
        double max=Integer.MIN_VALUE;
        for(int a:salary)  
        { 
            min=Math.min(min,a);
            max=Math.max(max,a);
            sum+=a;
        }
        sum=sum-min-max;
        int b=(salary.length)-2;
        double avg=sum/b;
        return avg;
    }
}

//Time Complexity : O(logN)
//Space Complexity : O(1)
