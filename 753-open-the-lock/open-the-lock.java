class Solution {
    class Pair {
        String str;
        int step;

        Pair(String str, int step) {
            this.str = str;
            this.step = step;
        }
    }

    public int openLock(String[] deadends, String target) {
        Set<String> seen = new HashSet<>();
        Queue<Pair> q = new LinkedList<>();
        String start = "0000";
        seen.add(start);
        q.add(new Pair(start, 0));

        for (String d : deadends) {
            if(d.equals(start)){
                return -1;
            }
            seen.add(d);
        }
        while (!q.isEmpty()) {
            Pair cur = q.remove();
            if (cur.str.equals(target))
                return cur.step;
            for (String nei : neighbors(cur.str)) {
                if (!seen.contains(nei)) {
                    seen.add(nei);
                    q.add(new Pair(nei, cur.step + 1));
                }
            }
        }
        return -1;
    }

    public List<String> neighbors(String ori) {
        char[] arr = ori.toCharArray();
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < ori.length(); i++) {
            char temp = arr[i];
            arr[i] = (char) ((temp - '0' + 1) % 10 + '0');
            ans.add(new String(arr));
            arr[i] = (char) ((temp - '0' + 9) % 10 + '0');
            ans.add(new String(arr));

            arr[i] = temp;
        }
        return ans;
    }
}