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
        List<String> neighbors = new LinkedList<>();
        Queue<Pair> queue = new LinkedList<>();
        seen = new HashSet<>();
        queue.add(new Pair(startGene, 0));
        while (!queue.isEmpty()) {
            Pair p = queue.remove();
            seen.add(p.node);
            for (String n : neighbors(p.node, bank)) {
                if (Arrays.stream(bank).anyMatch(x -> x.equals(n))) {
                    if (n.equals(endGene)) {
                        return p.times + 1;
                    }
                    queue.add(new Pair(n, p.times + 1));
                } else {
                    continue;
                }

            }
        }
        return -1;
    }

    public List<String> neighbors(String startGene, String[] bank) {
        List<String> ans = new ArrayList<>();
        int len = startGene.length();
        for (String endGene : bank) {
            for (int i = 0; i < len; i++) {
                if (!seen.contains(endGene) && startGene.charAt(i) != endGene.charAt(i)) {
                    ans.add(startGene.substring(0, i) + endGene.substring(i, i + 1) + startGene.substring(i + 1));
                }
            }
        }
        return ans;
    }
}