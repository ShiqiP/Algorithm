class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();

        if(!words.contains(endWord)) return 0;

        words.remove(beginWord);
        q.add(beginWord);
        
        int steps=0;
        while(!q.isEmpty()){
            int size = q.size();
            steps += 1;
            for(int i=0; i<size; i++){
                String cur = q.remove();
                if(cur.equals(endWord)){
                    return steps;
                }
                for(String n:neighbors(cur)){
                    if(words.contains(n)){
                        words.remove(n);
                        q.add(n);
                    }
                }
            }
        }
        return 0;
    }

    public List<String> neighbors(String str) {
        char[] arr = str.toCharArray();
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            char temp = arr[i];
            for (char c = 'a'; c <= 'z'; c++) {
                arr[i] = c;
                ans.add(new String(arr));
            }
            arr[i] = temp;
        }
        return ans;
    }
}