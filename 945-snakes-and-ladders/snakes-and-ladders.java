class Solution {
    class State{
        int index,step;
        boolean snake;
        State(int index,int step,boolean snake){
            this.index = index;
            this.step = step;
            this.snake = snake;
        }
    }
    boolean[] seen;
    Queue<State> queue;
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean toggle = true; // true col++  false col--
        int index = 1;
        int[] data = new int[n*n+1];
    

        // convert 2D array to 1D ordered array;
        for(int r=n-1; r>=0; r--){
            if(toggle){
                for(int c=0; c<n; c++){
                    data[index++] = board[r][c];
                }
            }else{
                for(int c=n-1; c>=0; c--){
                    data[index++] = board[r][c];
                }
            }
            toggle = !toggle;
        }
        // graph concept 
        queue = new LinkedList<>();
        queue.add(new State(1,0,false));
        seen = new boolean[n*n+1];
        seen[1] = true;
        while(!queue.isEmpty()){
            State cur = queue.remove();
            for(int r = 1; r <= 6; r++){
                int next = cur.index + r;
                if(next > n*n)
                    break;
                if(data[next] != -1){
                    next = data[next];
                }    

                if(next == n*n){
                    return cur.step + 1;
                }

                if(!seen[next]){
                    seen[next] = true;
                    queue.add(new State(next,cur.step+1,false));
                }
            }
        }
        return -1;
    }
}