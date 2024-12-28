class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // flag to indicate the previous slot
        // true there is a flower in the previous slot
        // false there is no flower 

        // plant a flower in current slot
        // current slot is available and flag == false 
        
        // flag == true the current slot is occupied. 
        // the previous operation violate the rule
        // decrement the result;
        boolean flag = false;
        int sum = 0;
        for(int i : flowerbed){
            if(i == 1){
                if(flag){   
                    sum--;
                }
                flag = true;
            }else{
                if(!flag){
                    sum++;
                    flag = true;
                }else{
                    flag = false;
                }
            }
        }
        return sum >= n;
    }
}