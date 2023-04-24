class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
        for(int stone : stones) pq.add(stone);
        while(pq.size() > 1) {
            int item1 = pq.remove();
            int item2 = pq.remove();
            if(item1 != item2) {
                pq.add(Math.abs(item1 - item2));
            }
        }
        return pq.isEmpty() ? 0 : pq.remove();
    }
}

//Time Complexity : O(N)
//Space Complexity : O(N)
