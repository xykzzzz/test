import java.util.*;

public class Test1 {
    //leet 387 字符串中第一个不重复的字符
    public static int firstUniqChar(String s) {
        Map<Character,Integer> map=new HashMap<>();
        char[]chars=s.toCharArray();
        for(char c:chars){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(int i=0;i<chars.length;i++){
            char x=chars[i];
            if(map.get(x)==1){
                return i;
            }
        }
        return -1;
    }
    //leetcode 349 两个数组的交交集
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set=new HashSet<>();
        Set<Integer> setResult=new HashSet<>();
        for(int x:nums1){
            set.add(x);
        }
        for(int x:nums2){
            if(set.contains(x)){
                setResult.add(x);
            }
        }
        int[] ret=new int[setResult.size()];
        int index = 0;
        for (int value : setResult) {
            ret[index++] = value;
        }
        return ret;

    }
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    };
    //leetcode690 员工的重要性
    public int getImportance(List<Employee> employees, int id) {
        for(Employee e:employees){
            if(e.id==id){
                if(e.subordinates.size()==0){
                    return e.importance;
                }
                for(int subId:e.subordinates){
                    e.importance+=getImportance(employees,subId);
                }
                return e.importance;
            }
        }
        return 0;
    }
}
