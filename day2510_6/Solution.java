package leetcodelx;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int evalRPN(String[] tokens) { //根据 逆波兰表示法，求表达式的值
        Deque<Integer> stack=new LinkedList<>();
        for(String s:tokens){
            switch(s){
                case "+":
                    stack.push(stack.pop()+stack.pop());
                    break;
                case"-":
                    int num=stack.pop();
                    stack.push(stack.pop()-num);
                    break;
                case"*":
                    stack.push(stack.pop()*stack.pop());
                    break;
                case"/":
                    int num2=stack.pop();
                    stack.push(stack.pop()/num2);
                    break;
                default:
                    stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}