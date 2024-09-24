package lam.chapter2;

import lam.pojo2.Author;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static lam.pojo2.Author.getAuthors;

public class CourseThree {
    public static void main(String[] args) {
        test17();
    }

    private static void test13(){
        List<Author> authors=getAuthors();
        long count = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .count();
        System.out.println(count);
    }

    private static void test14(){
        List<Author> authors=getAuthors();
        Optional<Integer> max = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(book -> book.getScore())
                .max(new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2 - o1;
                    }
                });
        Optional<Integer> max2 = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(book -> book.getScore())
                .max((o1,o2)->o1-o2);
        Optional<Integer> max3 = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(book -> book.getScore())
                .max(Comparator.naturalOrder());
        System.out.println(max3.get());
    }

    private static void test15(){
        List<Author> authors=getAuthors();
        Set<Author> collect = authors.stream()
                .collect(Collectors.toSet());
        System.out.println(collect.size());
    }

    private static void test16(){
        List<Author> authors=getAuthors();
        Optional<Author> first = authors.stream()
                .sorted((o1,o2)->o1.getAge()-o2.getAge())
                .findFirst();
        first.ifPresent(author->System.out.println(author.getName()));
    }

    private static void test17(){
        List<Author> authors=getAuthors();
        Integer reduce = authors.stream()
                .distinct()
                .map(author -> author.getAge())
                .reduce(0, (result, element) -> result + element);
        System.out.println(reduce);
    }
}
