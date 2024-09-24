package lam.chapter;

import java.util.stream.Stream;

public class CourseTwo {
    public static void main(String[]args){
        iterate();
    }
    static void generate(){
        Stream.generate(()->"hello world")
                .limit(2)
                .forEach(System.out::println);
    }
    static void iterate(){
        Stream.iterate(0,x->x+1)
                .limit(3)
                .forEach(System.out::println);
    }
}
