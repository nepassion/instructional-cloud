package lam.pojo2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
//@EqualsAndHashCode
public class Author implements Comparable<Author> {
    //主键ID
    private Long id;
    //姓名
    private String name;
    private Integer age;
    private String intro;
    private List<Book> books;

    public static List<Author> getAuthors_first() {
        //数据初始化
        Author author = new Author(1L, "蒙多", 33, "一个从菜刀中明悟哲理的祖安人", null);
        Author author2 = new Author(2L, "亚拉索", 15, "狂风也追逐不上他的思考速度", null);
        Author author3 = new Author(3L, "易", 14, "是这个世界在限制他的思维", null);
        Author author4 = new Author(3L, "易", 14, "是这个世界在限制他的思维", null);
        //书籍列表
        List<Book> books1 = new ArrayList<>();
        List<Book> books2 = new ArrayList<>();
        List<Book> books3 = new ArrayList<>();

        books1.add(new Book(1L, "刀的两侧是光明与黑暗", "哲学,爱情", 88, "用一把刀划分了爱恨"));
        books1.add(new Book(2L, "一个人不能死在同一把刀下", "个人成长,爱情", 99, "讲述如何从失败中明悟真理"));

        books2.add(new Book(3L, "那风吹不到的地方", "哲学", 85, "带你用思维去领略世界的尽头"));
        books2.add(new Book(3L, "那风吹不到的地方", "哲学", 85, "带你用思维去领略世界的尽头"));
        books2.add(new Book(4L, "吹或不吹", "爱情,个人传记", 56, "一个哲学家的恋爱观注定很难把他所在的时代理解"));

        books3.add(new Book(5L, "你的剑就是我的剑", "爱情", 56, "无法想象一个武者能对他的伴侣这么的宽容"));
        books3.add(new Book(6L, "风与剑", "个人传记", 100, "两个哲学家灵魂和肉体的碰撞会激起怎么样的火花呢?"));
        books3.add(new Book(6L, "风与剑", "个人传记", 100, "两个哲学家灵魂和肉体的碰撞会激起怎么样的火花呢?"));
        author.setBooks(books1);
        author2.setBooks(books2);
        author3.setBooks(books3);
        author4.setBooks(books3);
        List<Author> authorList = new ArrayList<>(Arrays.asList(author, author2, author3, author4));
        return authorList;
    }

    public static void main(String[] args) {
        List<Author> list=getAuthors();
        list.stream().forEach(System.err::println);
        System.out.println(list);
    }

    public static List<Author> getAuthors(){
        List<Book> books1 = new ArrayList<>();
        List<Book> books2 = new ArrayList<>();
        List<Book> books3 = new ArrayList<>();
        books1.add(new Book(1L, "java8函数", "编程", 60, "技术书籍"));
        books1.add(new Book(2L, "三国演义", "讲义气", 99, "讲述如何从失败中明悟真理"));

        books2.add(new Book(3L, "西游记", "神话", 85, "四个师徒的故事"));
        books2.add(new Book(3L, "西游记", "神话", 85, "四个师徒的故事"));
        books2.add(new Book(4L, "水浒传", "爱情,打架", 33, "108个好汉的故事"));

        books3.add(new Book(5L, "红楼梦", "爱情", 66, "一个特别苦逼的爱情故事"));
        books3.add(new Book(6L, "剑桥英语讲义", "英语书", 97, "纯粹的英语学习书籍?"));
        books3.add(new Book(6L, "剑桥英语讲义", "英语书", 97, "纯粹的英语学习书籍?"));

        Author author = new Author(1L, "Richard Warburton+吴冠中", 33, "一个中高级java开发老外", books1);
        Author author2 = new Author(2L, "吴承文+施耐庵", 48, "一个闷骚男", books2);
        Author author3 = new Author(3L, "曹雪芹+英语学习机构", 99, "是这个世界在限制他的思维11", books3);
        Author author4 = new Author(3L, "曹雪芹+英语学习机构", 99, "是这个世界在限制他的思维11", books3);

        List<Author> authorList=new ArrayList<>(Arrays.asList(author,author2,author3,author4));
        return authorList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id) &&
                Objects.equals(name, author.name) &&
                Objects.equals(age, author.age) &&
                Objects.equals(intro, author.intro) &&
                Objects.equals(books, author.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, intro, books);
    }

    @Override
    public int compareTo(Author o1) {
        return o1.getAge()-getAge();
    }
}
