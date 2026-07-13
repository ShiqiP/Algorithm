class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();
        int lastRowNum = triangle.get(height - 1).size();

        int[] minSumOfIndex = new int[lastRowNum + 1];

        for (int h = height - 1; h >= 0; h--) {
            List<Integer> row = triangle.get(h);
                System.out.println("--");
            for (int i = 0; i < row.size(); i++) {
                int min = Math.min(minSumOfIndex[i], minSumOfIndex[i + 1]);
                minSumOfIndex[i] = min + row.get(i);
                System.out.print(minSumOfIndex[i] + ",");
            }
        }
        return minSumOfIndex[0];
        /**
        minSumOfIndex
        0, 0, 0, 0, 0
        4, 1, 8, 3
        7, 6, 10
        3 +6， 4 + 6
        9，10
       11
         */

    }
}