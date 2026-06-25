class MyStack {

    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        queue.offer(x);
        for (int i = queue.size() - 1; i > 0; i--) {
            queue.offer(queue.poll());
        }
    }
    
    public int pop() {
        if(!empty()) return queue.poll();
        return -1;
    }
    
    public int top() {
        if(!empty()) return queue.peek();
        return -1;
    }
    
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */