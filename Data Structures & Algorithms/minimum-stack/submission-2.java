class MinStack {

    int min = Integer.MAX_VALUE;

    Stack<Pair> st;

    public MinStack() {
       st =  new Stack<Pair>();
    }
    
    public void push(int val) {
        if(!st.isEmpty()){
            min = Math.min(st.peek().min, val);
            st.push(new Pair(val, min));
        } else {
            st.push(new Pair(val, val));
        }
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        if(!st.isEmpty())
        return st.peek().data;
        else {
            return -1;
        }
    }
    
    public int getMin() {
        if(!st.isEmpty())
        return st.peek().min;
        else {
            return -1;
        }
    }
}

class Pair {
    int data;
    int min;

    Pair(int data, int min) {
        this.data = data;
        this.min  = min;
    }
}