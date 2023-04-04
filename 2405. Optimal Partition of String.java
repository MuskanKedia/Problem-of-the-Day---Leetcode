class Solution {
    public int partitionString(String s) {
        int count = (s.isEmpty()) ? 0 : 1;
        HashSet<Character> letters = new HashSet<Character>(); 
        for (int i = 0; i < s.length(); i++) {
            if (letters.contains(s.charAt(i))) {
                letters.clear(); 
                count++;
            }
            letters.add(s.charAt(i)); 
        }
        return count;
    }
}

//Time Complexity : O(n)
//Space Complexity : O(n)
