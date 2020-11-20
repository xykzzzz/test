package 刷题;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class D {
    public static boolean isValidSudoku(char[][] board) {
      int[][]row=new int[9][10];
        int[][]col=new int[9][10];
        int[][]box=new int[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j]=='.'){
                    continue;
                }
                int realNum=board[i][j]-'0';
                if(row[i][realNum]==1){
                    return false;
                }
                if(col[j][realNum]==1){
                    return false;
                }
                if(box[j/3+(i/3)*3][realNum]==1){
                    return false;
                }
                row[i][realNum]=1;
                col[j][realNum]=1;
                box[j/3 + (i/3) * 3][realNum]=1;
            }
        }
        return true;

    }



}
