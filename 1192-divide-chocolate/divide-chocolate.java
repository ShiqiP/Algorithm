class Solution {
    public int maximizeSweetness(int[] sweetness, int k) {
        // maximum sweetness we can get is equal to sum of the array divided by k

        // choose the sweetness and perform a cut function
        // compare the chunks after cutting and the k+1
        // if chunks >= k+1  mid meet the requirement 
        // left = mid (mid meet the requirement so we have to keep this figure)
        // else  it means the mid we choose is too big 
        // right = mid -1 ; we shrink the range to the left side;

        int left = 1;
        int right = 0;
        int total = 0;
        for(int s : sweetness){
            total += s;
        }
        right = total / (k+1);


        while(left < right){
            // why plus one is that we always set left = mid and maybe the current mid is the ans
            // but if there is no increment the while loop will be infinite.
            int mid = left + (right-left+1 )/2;
            // cut             
            int chunks = 0;
            int sum = 0;
            for(int s:sweetness){
                sum += s;
                if(sum >= mid){
                    chunks++;
                    sum = 0;
                }
            }
            // compare chunks and k+1 after cutting
            if(chunks >= k+1){
                left = mid;
            }else{
                right = mid-1;
            }
        }
        return left;
    }
}