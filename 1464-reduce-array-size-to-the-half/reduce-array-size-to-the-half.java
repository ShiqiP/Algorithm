class Solution {
    public int minSetSize(int[] arr) {
        // we need store the occurrences of the number
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> set = new ArrayList<>();
        for (int n : arr) {
            if (!map.containsKey(n)) {
                set.add(n);
            }
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // dec order based on the occurrences
        Collections.sort(set, (a, b) -> Integer.compare(map.get(b), map.get(a)));
        int half = 0;
        int index = 0;
        while (half < arr.length / 2) {
            int n = set.get(index++);
            half +=  map.get(n);
        }
        return index;

    }
}