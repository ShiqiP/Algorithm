// hash set is an array of LinkedList
class Bucket {
    private LinkedList<Integer> list;

    public Bucket() {
        this.list = new LinkedList<>();
    }

    public void insert(Integer key) {
        int index = list.indexOf(key);
        if (index == -1) {
            list.addFirst(key);
        }
    }

    public void remove(Integer key) {
        list.remove(key);
    }

    public boolean contains(Integer key) {
        return list.indexOf(key) != -1;
    }
}

class MyHashSet {

    static final int MOD = 2999;
    private Bucket[] arr;

    public MyHashSet() {
        this.arr = new Bucket[MOD];
        for (int i = 0; i < MOD; i++) {
            this.arr[i] = new Bucket();
        }
    }

    public void add(int key) {
        int hashCode = key % MOD;
        this.arr[hashCode].insert(key);
    }

    public void remove(int key) {
        int hashCode = key % MOD;
        this.arr[hashCode].remove(key);
    }

    public boolean contains(int key) {
        int hashCode = key % MOD;
        return this.arr[hashCode].contains(key);

    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */