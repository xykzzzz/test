package maptest;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Main {
    public static void main1(String[] args) {
        Map<String,Integer> map=new TreeMap<>();
  /*      map.put("A", 241);
        map.put("B", 250);
        map.put("C",263);
        map.put("D",589);
        System.out.println(map);
        Set<String> keys = map.keySet();
        for(String key:keys){
            Integer value = map.get(key);
            System.out.println(key+"="+value);
        }
        Set<Map.Entry<String, Integer>> maps = map.entrySet();
        System.out.println(maps);*/
        Integer v = map.put("A", 123);
        System.out.println(v);
        v= map.put("A",456);
         v = map.get("A");

        System.out.println(v);
        System.out.println(map);
        v = map.remove("A");
        System.out.println(v);
        System.out.println(map);
    }

    public static void main(String[] args) {
        MyMap map=new MyMap();
        Integer v = map.put("A", 123);
        System.out.println(v);
        v=map.put("A",456);
        v=map.get("A");
        v=map.getOrDefault("A",886);
        System.out.println(v);
    }
}
