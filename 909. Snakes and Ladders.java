class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Set<String> visited = new HashSet<String>();
        Queue<int[]> pos = new LinkedList<int[]>();
        pos.offer(new int[] {n-1, 0});
        int count = 0;
        while(!pos.isEmpty()){
            int size = pos.size();
            count++;
            while(size-- > 0){
                int[] next = pos.poll();
                visited.add(next[0] + "," + next[1]);
                for (int i = 1; i <= 6; i++){
                    int[] step = takeStep(board, next[0], next[1], i); 
                    if (step[0] == n && step[1] == n) return count;
                    if(board[step[0]][step[1]] != -1) {
                        step = getCord(n, board[step[0]][step[1]]);
                    }
                    if (step[0] == n && step[1] == n) return count;
                    if (!visited.contains(step[0]+","+step[1])) pos.offer(step);
                }                
            }
        }
        return -1;
    }
    public int[] takeStep(int[][] board, int row, int col, int steps){
        int n = board.length;
        int next = 0;
        if ( (n + row) % 2 == 0) next = (n - row - 1) * n + n - col + steps;
        else next = (n - row - 1) * n + col + 1 + steps;
        return getCord(n, next);
    }
    
    private int[] getCord(int n, int value){
        if (value >= n * n) return new int[] {n,n} ;
        int row = n - (value - 1) / n - 1;
        int col = 0;
        if ((n + row) % 2 == 0){
            if (value % n == 0) col = 0;
            else col = n - ((value - 1) % n) - 1;
        }else{
            if (value % n == 0) col = n-1;
            else col = ((value -1) % n);
        }
        return new int[] {row, col};
    }
}

//Time Complexity : O(N*N)
//Space Complexity : O(N*N)
