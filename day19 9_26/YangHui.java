package yanghui;
import java.util.ArrayList;
import java.util.List;



import java.lang.reflect.Array;

public class YangHui {
    public static List<List<Integer>> generate(int numRows){
        List<List<Integer>> outList=new ArrayList();
        for (int i = 0; i <numRows ; i++) {
            List<Integer> elemList=new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                elemList.add(1);
            }
            outList.add(elemList);
        }
        for (int i = 2; i <outList.size() ; i++) {
            List<Integer> elemList = outList.get(i);
            for (int j = 1; j <elemList.size()-1; j++) {
                int a = outList.get(i - 1).get(j - 1);
                int b = outList.get(i - 1).get(j);
                elemList.set(j,a+b);
            }
        }
        return outList;
    }
    public static void main(String[] args) {
        for (List<Integer> list : generate(5)) {
            System.out.println(list);
        }
    }
}
