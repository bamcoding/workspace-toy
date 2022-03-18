package com.example.java8.lesson2.methodReference;

import com.example.java8.lesson1.lamda.DefaultFoo;
import com.example.java8.lesson1.lamda.Foo;
import com.example.java8.lesson1.lamda.Greeting;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class MethodReferenceImpl {
    public static void run() {
        System.out.println(">> practiceMethodReference Start!!!");

        Function<Integer, String> intToString = i -> ""+i;
        System.out.println(intToString.apply(200));

        //이미 구현된 동일한 기능의 메소드가 있다면 메소트 참조를 한다.
        UnaryOperator<String> hi = Greeting::hi;
        System.out.println(hi.apply("leegunj"));

        Supplier<Greeting> supplier = Greeting::new;
        System.out.println(supplier.get().hello("leegunj"));

        Function<String, Greeting> leegunj = Greeting::new;
        System.out.println(leegunj.apply("leegunj").getName());

        Function<Integer, Integer> test1 = i -> 10+i;
        Function<Integer, Integer> test2 = i -> i * 2;
        System.out.println(test1.apply(10));
        System.out.println(test2.apply(20));
        System.out.println(test1.andThen(test2).apply(20));
        System.out.println(test1.compose(test2).apply(20));

        //불특정 다수의 인스턴스의 메소드를 참조?
        String[] names = {"lee","kim","sin"};
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));

        System.out.println(">> DefaultStaticMethod Start!!!");
        Foo foo = new DefaultFoo("leegunj");
        foo.printName();
        foo.printNameUpperCase();

        List<String> list = new ArrayList<>();
        list.add("lee");
        list.add("sin");
        list.add("kim");
        list.add("park");

        //1
        System.out.println("1. foreach ========");
        list.forEach(System.out::println);

        //2
        System.out.println("2. spliterator ========");
        Spliterator<String> spliterator = list.spliterator();
        Spliterator<String> spliterator1 = spliterator.trySplit();
        while(spliterator.tryAdvance(System.out::println));
        System.out.println("===============");
        while(spliterator1.tryAdvance(System.out::println));

        System.out.println("3. stream ======");
        List<String> list2 = list.stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("L"))
                .collect(Collectors.toList());

        System.out.println(list2.toString());

        System.out.println("4. removeIf =======");
        list.removeIf(s -> s.startsWith("l"));
        System.out.println(list.toString());

        System.out.println("5. comparaotr =======");
        Comparator<String> compare2 = String::compareToIgnoreCase;
        list.sort(compare2.reversed());
        System.out.println(list.toString());
    }
}
