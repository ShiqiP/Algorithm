class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int ans=0;
        int n = people.length;
        int l = 0, r = n - 1;
        // asc
        Arrays.sort(people);

        while (l <= r && l < n && r >= 0) {
            if (people[r] < limit) {
                if (people[r] + people[l] <= limit) {
                    r--;
                    l++;
                    ans++;
                }else{
                    r--;
                    ans++;
                }
            } else {
                ans++;
                r--;
            }
        }
        return ans;
    }
}