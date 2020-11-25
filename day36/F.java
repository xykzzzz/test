package 刷题;

import java.util.Scanner;

public class F {
    public static boolean isHuiWen(String s){
        int i=0;
        int right=s.length()-1;
        while (i<right) {
            if (s.charAt(i)!=s.charAt(right)){
                return false;
            }
            i++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str1=sc.nextLine();
        String str2=sc.nextLine();
        int count=0;
        for (int i = 0; i <=str1.length(); i++) {
            StringBuilder sb=new StringBuilder(str1);
            sb.insert(i,str2);
            if(isHuiWen(sb.toString())){
                count++;
            }
        }
        System.out.println(count);
    }
}
