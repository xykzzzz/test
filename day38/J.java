package 刷题;

import java.util.Scanner;

//abcd12345ed125ss123456789
//123456789 输出最长数字串
public class J {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String max = maxString(s);
        System.out.println(max);
    }

    private static String maxString(String s) {
        int left=0;
        int maxLength = 0;
        int end=0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                left++;
                if(maxLength<left){
                    maxLength=left;
                    end=i;
                }

            } else {
                left = 0;
            }
        }
        return s.substring(end-maxLength+1,end+1);
    }

}
