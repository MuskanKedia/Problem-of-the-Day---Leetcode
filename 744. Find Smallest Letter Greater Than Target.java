class Solution {
    public char nextGreatestLetter(char[] a, char x) {
        int n = a.length;
        int lo = 0, hi = n;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] > x)    
                hi = mid;
            else    
                lo = mid + 1;             
        }
        return a[lo % n];
    }
}

//Time Complexity : O(logN)
//Space Complexity : O(1)
