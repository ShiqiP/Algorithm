class Solution {
    public int maximum69Number(int num) {
        // change one digit at a time
        // and get the maximum number you can get by changing
        // main point is to operate the number
        // 9669 / 1000 = 9
        // 9669 % 1000 = 669

        // 669 / 100 = 6
        // 669 % 100 = 69

        // 669 / 100 = 6
        // 669 % 100 = 69

        // 69 / 10 = 6
        // 69 % 10 = 9

        // 9 / 1 = 9
        // 9 % 1 = 9
        int n=1;
        int temp = num;
        while(temp > 0){
            temp = temp / 10;
            n++;
        }
        temp = num;
        for(int i=n-1;i>=0;i--){
            int time = (int)Math.pow(10,i);
            if(temp /time == 6){
                return num + 3 * time;
            }
            temp %= time;
        }
        return num;
    }
}