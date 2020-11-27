package 刷题;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*       (()())",6
        返回：true
        测试样例：
        "()a()()",7
        返回：false
        测试样例：
        "()(()()",7
        返回：false*/
public class K {
    public boolean chkParenthesis(String A, int n) {
        // write code here
        Deque<Character> stack=new LinkedList<>();
        char []charArray=A.toCharArray();
        for (char c:charArray) {
            if(c=='('){
                stack.push(c);
            }else if(c==')'){
                if(stack.isEmpty()){
                    return false;
                }
                char left=stack.pop();
                if(!(left=='('&&c==')')){
                    return false;
                }
            }
            else{
                return false;
            }
        }
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
