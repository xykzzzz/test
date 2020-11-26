package 刷题;

import java.util.Scanner;

public class H{
    //喝汽水
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int empty;
        while (sc.hasNext()){
            empty=sc.nextInt();
            if(empty==0){
                break;
            }
            System.out.println(drink(empty));
        }
    }

    public static int drink(int empty) {
        int sd=0;
     while (empty>2){
         sd=sd+empty/3;
         empty=empty/3+empty%3;
     }
     if(empty==2){
         sd=sd+1;
     }
     return sd;
    }
}