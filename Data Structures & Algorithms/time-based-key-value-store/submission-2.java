class TimeMap {

    Map<String, List<Node>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) map.put(key, new LinkedList<>());
        map.get(key).add(new Node(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        List<Node> data = map.get(key);
        // System.out.println("heamt");
        int l = 0;
        int r = data.size() - 1;
        String res = "";
        while (l <= r) {
            int m = l + (r - l) / 2;
            Node mNode = data.get(m);
            if (mNode.t == timestamp) return data.get(m).val;
            if (mNode.t > timestamp) {
                
                r = m - 1;
            } else {
                res = mNode.val;
                l = m + 1;
            }
        }

        return res;
    }

    class Node {
        String val;
        int t;

        Node(String val, int t) {
            this.val = val;
            this.t = t;
        }
    }
}
