package lam.chapter;

public class SingleTonEager {
    private static final SingleTonEager instance=new SingleTonEager();
    private SingleTonEager(){}
    public static SingleTonEager getInstance(){
        return instance;
    }
}
