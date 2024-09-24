package lam.chapter;

public class SingleTonLazy2 {
    private static SingleTonLazy2 instance;
    private SingleTonLazy2(){}
    public static SingleTonLazy2 getInstance(){
        if(instance==null){
            instance=new SingleTonLazy2();
        }
        return instance;
    }

}
