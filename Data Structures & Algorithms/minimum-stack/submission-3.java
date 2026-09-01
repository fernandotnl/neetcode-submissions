class MinStack {

    Stack<Integer> minStack;
    Stack<Integer> stack;
    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()) {
            minStack.push(val);
        } else {
            int minVal = minStack.peek();
            if (minVal >= val) {
                minStack.push(val);
            }
        }
        stack.push(val);
    }
    
    public void pop() {
        int val = stack.pop();
        if (minStack.peek() == val) {
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
