package day8;

import java.util.ArrayList;
import java.util.Stack;

class MinStack {

    Stack<Integer> stack;
    int minKey = Integer.MAX_VALUE;
    ArrayList<Integer> table;

    public MinStack() {
        stack = new Stack<>();
        table = new ArrayList<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minKey>val){
            minKey = val;
        }
        table.add(val);
    }

    public void pop() {
        int tmp = stack.pop();
        table.remove(table.indexOf(tmp));
        if (tmp==minKey) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < table.size(); i++) {
                if (table.get(i)<min) min=table.get(i);
            }
            minKey = min;
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minKey;
    }
}
