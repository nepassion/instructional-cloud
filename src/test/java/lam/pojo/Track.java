package lam.pojo;

/**
 * 曲子
 */
public class Track {
    //曲子名称
    private final String name;
    //轨道长度
    private final int length;

    public Track(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public String getName(){
        return name;
    }
    public int getLength(){
        return this.length;
    }

    public Track copyNew(){
        return new Track(name,length);
    }

}
