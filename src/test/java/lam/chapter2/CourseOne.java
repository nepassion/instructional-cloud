package lam.chapter2;

import lam.pojo2.Author;

import java.util.List;
import java.util.stream.Collectors;

public class CourseOne {
    private static List<Author> listAuthors=Author.getAuthors();

    private static List<Author> getAuthor(){
        return null;
    }
    public static void main(String[] args) {
//        List<Author> list=Author.getAuthors();
//        List<Author> authorsList=list.stream()
//                .distinct()
//                .filter(e->e.getAge()==99)
//                .collect(Collectors.toList());
//        System.out.println(authorsList);
        test02();
    }
    public static void test(){
        List<Author> list=listAuthors.stream()
                .peek(e->{
                    if(e.getId()==1L){
                        e.setName("我改变了她她她她她她");
                    }
                })
                .collect(Collectors.toList());
        System.out.println(list);
        System.out.println(listAuthors);

    }

    private static void test02(){
        listAuthors.stream()
                .distinct()
                .sorted()
                .sorted((o1,o2)->o2.getAge()-o1.getAge())
                .forEach(o->System.out.println(o.getAge()));
    }
}
