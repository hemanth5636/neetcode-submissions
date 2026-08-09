class LRUCache {

    private Map<Integer, Node> map;
    private int capacity;
    private Node front;
    private Node end;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        front = new Node(-1, -1);
        end = new Node(-1, -1);
        front.next = end;
        end.prev = front;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node get = map.get(key);
        get.prev.next = get.next;
        get.next.prev = get.prev;

        get.next = end;
        get.prev = end.prev;
        end.prev.next = get;
        end.prev = get;

        return get.val;
    }
    
    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            Node nn = new Node(key, value);
            nn.prev = end.prev;
            nn.next = end;

            end.prev.next = nn;
            end.prev = nn;
            map.put(key, nn);
        } else {
            Node nn = map.get(key);
            nn.val = value;
            get(key);
        }

        if (map.size() > capacity) {
            Node nn = front.next;
            map.remove(nn.key);

            nn.prev.next = nn.next;
            nn.next.prev = nn.prev;
        }
    }
}

class Node {
    int val;
    int key;
    Node next;
    Node prev;

    Node(int key, int val) {
        this.val = val;
        this.key = key;
    }
}
