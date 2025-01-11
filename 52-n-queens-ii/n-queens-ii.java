class Solution {
    private int size;

    public int totalNQueens(int n) {
        size = n;
        // start from each row 
        return backtrack(0,new HashSet<>(),new HashSet<>(),new HashSet<>());
    }

    public int backtrack(int row, Set<Integer> cols, Set<Integer> diagonals, Set<Integer> antiDiagonals) {
        if(row == size){
            return 1;
        }
        int result = 0;
        for(int col = 0; col<size; col++){
            if(cols.contains(col) || diagonals.contains(row-col) || antiDiagonals.contains(row+col)){
                continue;
            }
            cols.add(col);
            diagonals.add(row-col);
            antiDiagonals.add(row+col);
            result += backtrack(row+1,cols,diagonals,antiDiagonals);
            cols.remove(col);
            diagonals.remove(row-col);
            antiDiagonals.remove(row+col);
        }
        return result;
    }

}