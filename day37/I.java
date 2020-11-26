package 刷题;

public class I {
    //数组中的逆序对 时间复杂度为o(n^2) 暴力解法
        public int count(int[] A, int n) {
            // write code here
            int count =0;
            for (int i = 0; i < n; i++) {
                for (int j =i+1; j < n; j++) {
                    if(A[i]>A[j]){
                        count++;
                    }
                }
            }
            return count;
        }
    }

