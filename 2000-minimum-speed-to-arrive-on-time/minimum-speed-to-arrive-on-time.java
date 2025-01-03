class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        // 2  hour = 1.9 2
        if(dist.length > Math.ceil(hour))
            return -1;

        // minimum speed
        int left = 1;
        int right = (int) Math.pow(10,7);
        
        while(left <= right){
            int mid = left + (right-left)/2;
            if(check(mid,dist,hour)){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
    public boolean check(int speed,int[] dist, double hour){
        double total = 0;
        for(int i=0; i<dist.length;i++){
            if(i == dist.length - 1 ){
                total += dist[i] / (double) speed;
            }else{
                total += Math.ceil(dist[i] / (double)speed);
            }
        }
        return total <= hour;
    }
}