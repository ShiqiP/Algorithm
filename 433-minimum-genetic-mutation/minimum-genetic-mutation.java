class Solution {
    class Pair {
        String node;
        int times;

        Pair(String node, int times) {
            this.node = node;
            this.times = times;
        }
    }

    Set<String> seen;

    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> BANK = new HashSet<>(Arrays.asList(bank));
        if (!BANK.contains(endGene))
            return -1;

        char[] options = { 'A', 'C', 'G', 'T' };
        Queue<Pair> queue = new LinkedList<>();
        seen = new HashSet<>();
        queue.add(new Pair(startGene, 0));

        while (!queue.isEmpty()) {
            Pair p = queue.remove();
            if(p.node.equals(endGene)){
                return p.times;
            }
            seen.add(p.node);
            char[] arr = p.node.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                for (char c : options) {
                    char temp = arr[i];
                    arr[i] = c;
                    String n = new String(arr);
                    arr[i] = temp;
                    System.out.println(n);
                    if (!seen.contains(n) && BANK.contains(n)) {
                        queue.add(new Pair(n, p.times + 1));
                        seen.add(n);
                    }
                }

            }
        }
        return -1;
    }
}