package hash表;

import java.util.Arrays;

public class 引用hash表 {
    public static void main(String[] args) {
        String s="azxdbcdewlafsdalfkjdofjadsfjlzjoidfjoz";
        int[] count=new int[26];
        for (char c:s.toCharArray()) {
            int idx=c-'a';
            count[idx]++;
        }
        System.out.println(Arrays.toString(count));
    }
}
