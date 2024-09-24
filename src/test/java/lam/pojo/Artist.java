package lam.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 艺术家
 */
@NoArgsConstructor
public final class Artist {

    public static void main(String[] args) {
        System.out.println(Collections.emptyList());
    }

    private String name;
    private List<Artist> members;
    private String nationality;

    /**
     * 艺术家
     * @param name
     * @param nationality
     */
    public Artist(String name,String nationality){
        this(name, Collections.emptyList(),nationality);
    }

    /**
     * Artist 构造器
     * @param name
     * @param members
     * @param nationality
     */
    public Artist(String name,List<Artist> members,String nationality){
        Objects.requireNonNull(name);
        Objects.requireNonNull(members);
        Objects.requireNonNull(nationality);
        this.name=name;
        this.members=new ArrayList<>(members);
        this.nationality=nationality;
    }

    public String getName(){
        return name;
    }
    public Stream<Artist> getMembers(){
        return members.stream();
    }

    public String getNationality(){
        return nationality;
    }

    public boolean isSolo(){
        return members.isEmpty();
    }

    public boolean isFrom(String nationality){
        return this.nationality.equals(nationality);
    }

    public String toString(){
        return getName();
    }

    public Artist copy(){
        List<Artist> members=getMembers().map(Artist::copy).collect(Collectors.toList());
        return new Artist(name,members,nationality);
    }

}
