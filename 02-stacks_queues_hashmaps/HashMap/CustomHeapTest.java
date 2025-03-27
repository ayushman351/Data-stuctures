import java.util.LinkedList;
import java.util.List;

class CustomHashMap<K, V> {
    private static final int SIZE = 16;
    private List<Entry<K, V>>[] table;

    public CustomHashMap() {
        table = new List[SIZE];
        for (int i = 0; i < SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public void put(K key, V value) {
        int index = Math.abs(key.hashCode()) % SIZE;
        List<Entry<K, V>> bucket = table[index];
        
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        
        bucket.add(new Entry<>(key, value));
    }

    public V get(K key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        List<Entry<K, V>> bucket = table[index];
        
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        
        return null;
    }

    public void remove(K key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        List<Entry<K, V>> bucket = table[index];
        
        bucket.removeIf(entry -> entry.key.equals(key));
    }
}

public class CustomHeapTest {
    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        
        // Adding key-value pairs
        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Orange", 3);

        // Retrieving value
        System.out.println("Apple: " + map.get("Apple"));  // Output: 1

        // Removing a key-value pair
        map.remove("Banana");

        // Checking if the key "Banana" exists
        System.out.println("Banana: " + map.get("Banana"));  // Output: null
    }
}
