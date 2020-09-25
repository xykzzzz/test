package bracket;
import java.util.Deque;
import java.util.LinkedList;

class MinStack {
    private Deque<Integer> min;
    private Deque<Integer> stack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        min = new LinkedList<>();
        stack = new LinkedList<>();
    }

    public void push(int x) {
        stack.push(x);
        if (min.isEmpty()) {
            min.push(x);
        } else {
            int t = min.peek();
            if (x < t) {
                min.push(x);
            } else {
                min.push(t);
            }
        }
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }

    public static void main(String[] args) {

    }
}