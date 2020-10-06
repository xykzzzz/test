package leetcodelx;

import java.util.Deque;
import java.util.LinkedList;

public class Solution1 {
    public static boolean backspaceCompare(String S, String T) {
        char[]ss=S.toCharArray();
        char[]tt=T.toCharArray();
        Deque<Character> stack=new LinkedList<>();
        Deque<Character> stack1=new LinkedList<>();
        for (int i = 0; i <ss.length ; i++) {
            if(ss[i]!='#'){
                stack.push(ss[i]);
            }else {
                if(stack.size()!=0)
                    stack.pop();
            }
        }
        for (int j = 0; j<tt.length ; j++) {
            if (tt[j] != '#') {
                stack1.push(tt[j]);
            } else {
                if (stack1.size() != 0)
                    stack1.pop();
            }
        }
        if(stack.size()!=stack1.size()){
            return false;
        }
        while(stack.size()!=0){
            if(stack.pop()!=stack1.pop())
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String S="a#c";
        String T="a#c";
        System.out.println(backspaceCompare(S,T));
    }
}
