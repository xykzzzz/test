package sort;

import java.util.*;

class person{
    String name;
    int age;
    int height;

    @Override
    public String toString() {
        return "person{" +
                "age=" + age +
                '}';
    }
}
public class 使用jdk提供的排序 {
    public static String[] peoples={"张三","李四","王五","刘六","七七"};
    public static void main(String[] args) {
        person[] people=new person[5];
        for (int i = 0; i < 5; i++) {
            people[i]=new person();
        }
        List<String> nameOld= Arrays.asList(peoples);
        List<String> names=new ArrayList<>(nameOld);
        Collections.shuffle(names);
        Random  random=new Random();
        for (int i = 0; i < 5; i++) {
            people[i].name=names.remove(0);
            people[i].age=random.nextInt(30)+5;
            people[i].height=random.nextInt(120)+5;
        }
        Arrays.sort(people, new Comparator<person>() {
            @Override
            public int compare(person o1, person o2) {
                return o1.age-o2.age;
            }
        });
        System.out.println(Arrays.toString(people));
    }
}
