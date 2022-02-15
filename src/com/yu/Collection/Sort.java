package com.yu.Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author:Yuzhiqiang
 * @Description:
 * @Date: Create in 20:30 2022/2/15
 * @Modified By:
 */
public class Sort {
    public static void main(String[] args) {
        Person p1 = new Person("zhang1", 1);
        Person p2 = new Person("zhang2", 5);
        Person p3 = new Person("zhang3", 3);
        Person p4 = new Person("zhang4", 0);
        Person p5 = new Person("zhang5", 9);
        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        Collections.sort(list, new Comparator<Person>() {
            public int compare(Person a, Person b) {
                return a.getAge() - b.getAge();
            }
        });
//        Collections.sort(list);
        for(int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}

class Person{
    private String name;
    private int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String toString() {
        return this.name + " " + this.age;
    }
}
