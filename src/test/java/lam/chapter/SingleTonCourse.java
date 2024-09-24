package lam.chapter;

public class SingleTonCourse {
    private SingleTonCourse(){}
    private static class staticInstance{
        private static final SingleTonCourse instance=new SingleTonCourse();
    }
    public static SingleTonCourse getInstance(){
        return staticInstance.instance;
    }

    public static void main(String[] args) {
        SingleTonCourse s=SingleTonCourse.getInstance();
        SingleTonCourse s2=SingleTonCourse.getInstance();
        System.out.println(s==s2);
        System.out.println(s.hashCode());
        System.out.println(s2.hashCode());

    }
}
