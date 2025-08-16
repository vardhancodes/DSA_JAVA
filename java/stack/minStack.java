import java.util.Stack;
public class minStack{

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(5);
        obj.push(3);
        obj.push(7);
        obj.push(2);
        System.out.println("Current Min: " + obj.getMin());
        obj.pop();
        System.out.println("Top element: " + obj.top());
        System.out.println("Current Min: " + obj.getMin());
    }


}


//Min stack:

class MinStack {
    Stack<Integer> stack;     // main stack to store all values
    Stack<Integer> minstack;  // auxiliary stack to store the current minimums
    
    public MinStack(){
        stack = new Stack<>();
        minstack = new Stack<>();
    }
    
    // Push operation
    // 1. Always push the value into main stack
    // 2. For minstack:
    //    - If it's empty or the new value is smaller than the current minimum, push the new value
    //    - Otherwise, push the current minimum again (so size of both stacks stays same)
    public void push(int val) {
        stack.push(val);
        if(minstack.isEmpty() || minstack.peek() > val) {
            minstack.push(val);
        } else {
            minstack.push(minstack.peek());
        }
    }
    
    // Pop operation
    // 1. Pop from both stacks simultaneously (to keep them in sync)
    public void pop() {
        if(!stack.isEmpty() && !minstack.isEmpty()) {
            stack.pop();
            minstack.pop();
        }
    }
    
    // Top operation
    // 1. Just return the top element of main stack
    public int top() {
        return stack.peek();
    }
    
    // GetMin operation
    // 1. The top of minstack always stores the minimum value till now
    public int getMin() {
        return minstack.peek();
    }
}
