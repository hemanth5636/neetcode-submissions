class MyQueue {
    Stack<Integer> a;
    Stack<Integer> b;

    public MyQueue() {
        a = new Stack<>();
        b = new Stack<>();
    }
    
    public void push(int x) {

        while (!a.isEmpty()) {
            b.push(a.pop());
        }

        Stack<Integer> tmp = a;
        a = b;
        b = tmp;

        a.push(x);

        while (!a.isEmpty()) {
            b.push(a.pop());
        }

        tmp = a;
        a = b;
        b = tmp;
    }
    
    public int pop() {
        return a.pop();
    }
    
    public int peek() {
        return a.peek();
    }
    
    public boolean empty() {
        return a.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */