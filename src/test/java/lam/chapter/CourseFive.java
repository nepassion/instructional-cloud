package lam.chapter;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class CourseFive {

    private CourseFive(){}
    private static CourseFive courseFive=new CourseFive();
    public CourseFive getInstance(){
        return courseFive;
    }
    public static void main(String[]args){
        ceshiMultiple();
    }
    private static void ceshiPredicate(){
        List<Integer> numbers= Arrays.asList(1,2,3,4,5,6);
        Predicate<Integer> isEven= num->num%2==0;
        List<Integer> evenNumbers=numbers.stream()
                .filter(isEven)
                .collect(Collectors.toList());
        System.out.println(evenNumbers);
    }
    private static void ceshiFunction(){
        List<String> strings=Arrays.asList("apple","banana","cherry");
        Function<String,Integer> getLength= str->str.length();
        List<Integer> lengths=strings.stream()
                .map(getLength)
                .collect(Collectors.toList());
        System.out.println(lengths);
    }

    private static void ceshiConsumer(){
        List<String> strings=Arrays.asList("apple","banana","cherry");
        Consumer<String> printString= str-> System.out.println(str);
        strings.forEach(printString);
    }

    private static void ceshiSuppiler(){
        Random random=new Random();
        Supplier<Integer> randomIntSupplier=()->random.nextInt(100);
        for(int i=0;i<5;i++){
            System.out.println(randomIntSupplier.get());
        }
    }
    private static List<String> fruits=Arrays.asList("apple","banana","watermelon","peach","pear");
    private static void ceshiMultiple(){
        List<String> fruitsList=fruits.stream()
                .filter(s->s.length()>3||s.startsWith("b"))
                .collect(Collectors.toList());
        fruitsList.stream().forEach(System.err::println);
        System.out.println(fruitsList);
    }
}
