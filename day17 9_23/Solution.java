package bracket;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    public static boolean isValid(String s) {
        Deque<Character> stack=new LinkedList<>();
        char[] charArray=s.toCharArray();
        for (char c:charArray) {
            switch (c) {
                case '[':
                case '{':
                case '(':
                    stack.push(c);
                    break;
                default: {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    char left = stack.pop();
                    if (!compareBracket(left, c)) {
                        // 左括号和右括号不匹配
                        return false;
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            // 左括号多了
            return false;
        }
    }


    private static boolean compareBracket(char left, char right) {
        if (left == '(' && right == ')') {
            return true;
        }

        if (left == '[' && right == ']') {
            return true;
        }

        if (left == '{' && right == '}') {
            return true;
        }

        // 除了上面这三种情况以外的所有情况，都是不匹配
        return false;
    }

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String s=in.nextLine();
        boolean t=isValid(s);
        System.out.println(t);
    }
}
