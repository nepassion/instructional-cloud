package lam.chapter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@FunctionalInterface
interface Adder{
    int add(int a ,int b);
}
@FunctionalInterface
interface SortStr{
    String sort(List<String> list);
}

public class CourseFour {
    static void sortStr(){
        List<String> letterList= Arrays.asList("a","bb","vocabulary");
        SortStr sortStr=(List<String> list)->{
            list.sort(Comparator.comparingInt(String::length).reversed());
            return String.join(",",list);
        };
        String sortedString= sortStr.sort(letterList);
        System.out.println(sortedString);
    }
    public static void main(String[] args) {
        Adder adder=(a,b)->a+b;
        int result=adder.add(3,4);
        System.out.println(result);
        sortStr();
    }

}
