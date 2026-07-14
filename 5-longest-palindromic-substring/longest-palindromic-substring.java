class Solution {
    public String longestPalindrome(String s) {
        // babad
        // verify and return the length of the palindrome
        int[] arr = new int[2];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            // odd length

            int oddLength = getLengthOfPalindrome(i, i, s);
            if (oddLength > arr[1] - arr[0] + 1) {
                arr[0] = i - oddLength / 2;
                arr[1] = i + oddLength / 2;
            }
            // aabbaa
            int evenLength = getLengthOfPalindrome(i, i + 1, s);
            if (evenLength > arr[1] - arr[0] + 1) {
                arr[0] = i - (evenLength / 2 - 1);
                arr[1] = i + evenLength / 2;
            }

        }
        // 
        return s.substring(arr[0], arr[1] + 1);
    }

    public int getLengthOfPalindrome(int i, int j, String s) {
        while(i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }

        return j - i - 1;
    }
}