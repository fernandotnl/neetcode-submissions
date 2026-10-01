class LRUCache {

    Map<Integer, Integer> readMap = new HashMap<Integer, Integer>();
    LinkedList<Integer> queue = new LinkedList<>();
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        int value = readMap.getOrDefault(key, -1);
        if(value >=0) {
            this.put(key, value);
        }
        return value;
    }
    
    public void put(int key, int value) {
        int size = queue.size();
        if (size < this.capacity || readMap.containsKey(key)) {
            queue.remove((Integer) key);
        } else {
            int keyToRemove = queue.peek();
            readMap.remove(keyToRemove);
            queue.poll();
        }
        queue.offer(key);
        readMap.put(key, value);
    }


}
