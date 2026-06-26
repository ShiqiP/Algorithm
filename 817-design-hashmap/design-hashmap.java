class Pair<T, U> {
    T key;
    U value;

    public Pair(T key, U value) {
        this.key = key;
        this.value = value;
    }
}

class Bucket {
    private List<Pair<Integer, Integer>> bucket;

    public Bucket() {
        this.bucket = new LinkedList<Pair<Integer, Integer>>();
    }

    public void add(Integer key, Integer value) {
        for (Pair<Integer, Integer> p : bucket) {
            if (p.key.equals(key)) {
                p.value = value;
                return;
            }
        }
        bucket.add(new Pair(key, value));
    }

    public Integer get(Integer key) {
        for (Pair<Integer, Integer> p : bucket) {
            if (p.key.equals(key)) {
                return p.value;
            }
        }
        return -1;
    }

    public void remove(Integer key) {
        for (Pair<Integer, Integer> p : bucket) {
            if (p.key.equals(key)) {
                this.bucket.remove(p);
                break;
            }
        }
    }
}

class MyHashMap {
    // an array of LinkedList
    // initialize an array
    Bucket[] map;
    int space = 2069;

    public MyHashMap() {
        this.map = new Bucket[this.space];
        for (int i = 0; i < map.length; i++) {
            map[i] = new Bucket();
        }
    }

    public void put(int key, int value) {
        int hashKey = key % space;
        this.map[hashKey].add(key, value);
    }

    public int get(int key) {
        int hashKey = key % space;
        return this.map[hashKey].get(key);
    }

    public void remove(int key) {
        int hashKey = key % space;
        this.map[hashKey].remove(key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */