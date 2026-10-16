
class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    String word = null;

    TrieNode() {
    }
}

class Solution {
    List<String> ans;
    Set<String> set;
    char[][] board;
    int m;
    int n;

    public List<String> findWords(char[][] board, String[] words) {
        // a. permutation every word posibility
        // this.set = new HashSet<>();
        // if words.contains(word) add it to the list
        // b. instead of a, build a trie. only when the char matched the first letter of word(trie children) then backtrack
        TrieNode root = new TrieNode();
        for(String word : words){
            TrieNode node = root;
            for(char c : word.toCharArray()){
                if(node.children.containsKey(c)){
                    node = node.children.get(c);
                }else{
                    TrieNode newNode = new TrieNode();
                    node.children.put(c, newNode);
                    node = newNode;
                }
            }
            node.word = word;
        }
        this.ans = new ArrayList<>();
        this.m = board.length;
        this.n = board[0].length;
        this.board = board;
        // Arrays.stream(words).forEach(set::add);

        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++) {
                if(root.children.containsKey(this.board[i][j])){
                    backtrack(i, j, root);
                }
            }
        }
        return ans;
    }

    public void backtrack(int i, int j, TrieNode node) {
        if(node.word != null){
            this.ans.add(node.word);
            node.word = null;
        }

        if (i < 0 || i >= this.m || j < 0 || j >= this.n)
            return;

        char c = this.board[i][j];

        if (c == '#')
            return; // visited

        if(!node.children.containsKey(c)) return;

        this.board[i][j] = '#';

        TrieNode nextNode = node.children.get(c);

        backtrack(i, j + 1, nextNode);
        backtrack(i, j - 1, nextNode);
        backtrack(i + 1, j, nextNode);
        backtrack(i - 1, j, nextNode);

        this.board[i][j] = c;


        return;
    }
}