class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        
        Map<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()){
            int freq = map.getOrDefault(c, 0);
            map.put(c, freq + 1);
        }

        for(char c : t.toCharArray()){
            
            if(!map.containsKey(c)) return false;

            map.put(c, map.get(c) - 1);
        }

        for(int value : map.values()){
            if(value > 0) return false;
        }

        return true;
    }
}