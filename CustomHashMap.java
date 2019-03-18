import java.util.LinkedList;
import java.util.List;

public class CustomHashMap<K,V> {

    private static class CustomEntry<K,V> {
        K k;
        V v;

        CustomEntry(K k, V v) {
            this.k = k;
            this.v = v;
        }

        public K getKey() {
            return k;
        }

        public V getValue() {
            return v;
        }

        public void setValue(V v) {
            this.v = v;
        }
    }

    int capacity;
    List<CustomEntry>[] buckets;

    CustomHashMap(int capacity) {
        this.capacity = capacity;
        buckets = new LinkedList[capacity];
    }

    public V get(K k) {
        int idx = Math.abs(k.hashCode()%capacity);
        if(buckets[idx] == null) return null;
        CustomEntry customEntry = find(buckets[idx], k);
        if(customEntry == null) return null;
        return (V) customEntry.getValue();
    }

    public void put(K k, V v) {
        int idx = Math.abs(k.hashCode()%capacity);
        if(buckets[idx] == null) buckets[idx] = new LinkedList<>();
        CustomEntry customEntry = find(buckets[idx], k);
        if(customEntry == null) {
            buckets[idx].add(new CustomEntry(k,v));
            return;
        }
        customEntry.setValue(v);
    }

    private CustomEntry find(List<CustomEntry> list, K k) {
        for(CustomEntry entry : list) {
            if(entry.getKey().equals(k)) return entry;
        }
        return null;
    }
}
