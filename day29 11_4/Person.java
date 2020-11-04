package hash表;

import java.util.HashSet;
import java.util.Objects;

public class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
    public static void main(String[] args) {
        Person p1 = new Person("gb", 18);
        Person p2 = new Person("gb", 18);

        HashSet<Person> set = new HashSet<>();
        set.add(p1);
        System.out.println(set.contains(p2));
        // 我想返回 true，必须重写 hashCode 和 equals


        /*
        HashMap<Person, String> map = new HashMap<>();
        map.put(p1, "gb");
        System.out.println(map.get(p2));

         */
    }
}
