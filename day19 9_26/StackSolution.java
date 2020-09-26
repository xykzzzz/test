package bracket;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class StackSolution {
    private static List<Integer> intArrayToList(int[] array){
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i <array.length ; i++) {
            list.add(array[i]);
        }
        return list;
    }
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        Deque<Integer> stack=new LinkedList<>();
        List<Integer> pushList=intArrayToList(pushA);
        List<Integer> popList=intArrayToList(popA);
        while (!popList.isEmpty()){
            Integer p = popList.remove(0);
            while (true){
                if(stack.isEmpty()||stack.peek()!=p){
                    if(pushList.isEmpty()){
                        return false;
                    }
                    Integer q=pushList.remove(0);
                    stack.push(q);
                }else {
                    break;
                }
            }
            stack.pop();
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int []pushA={1,2,3};
        int []popA={1,2,3};
        boolean t=IsPopOrder(pushA,popA);
    }
}