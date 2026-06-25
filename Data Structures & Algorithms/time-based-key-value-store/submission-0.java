class TimeMap {

    Comparator<Pair> comparator = Comparator.comparing(Pair::getKey)
            .thenComparing(Pair::getTimestamp);

    ArrayList<Pair> pairs = null;

    public TimeMap() {
        pairs = new ArrayList<Pair>();
    }

    public void set(String key, String value, int timestamp) {
        Pair pair = new Pair(timestamp, key, value);
        int index = Collections.binarySearch(pairs, pair, comparator);  
        if (index < 0) {
            index = ~index; // Convert to insertion point
        }
        pairs.add(index, pair);
    }

    public String get(String key, int timestamp) {
        Pair pair = new Pair(timestamp, key, null);
        int index = Collections.binarySearch(pairs, pair, comparator);
        if (index < 0) {
            index = ~index - 1; // Find the largest timestamp less than or equal to the given timestamp
        }
        while (index >= 0 && !pairs.get(index).key.equals(key)) {
            index--; // Ensure the key matches
        }
        if (index >= 0) {
            return pairs.get(index).value;
        }
        return "";
    }
}

class Pair {

    int timestamp;
    String key;
    String value;

    public Pair(int timestamp, String key, String value) {
        this.timestamp = timestamp;
        this.key = key;
        this.value = value;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
