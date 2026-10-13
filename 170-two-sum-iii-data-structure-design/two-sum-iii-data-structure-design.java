
import java.security.KeyStore.Entry;

class TwoSum {

    Map<Integer, Integer> map;

    public TwoSum() {
        this.map = new HashMap<>();
    }

    public void add(int number) {
        this.map.put(number, 1 + this.map.getOrDefault(number, 0));
    }

    public boolean find(int value) {
        for (Integer n : map.keySet()) {
            Integer another = value - n;
            if (this.map.containsKey(another)) {
                if (another != n) {
                    return true;
                } else {
                    if (this.map.get(another) > 1)
                        return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */