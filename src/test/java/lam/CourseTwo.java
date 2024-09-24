package lam;

import lam.pojo.Peach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 */
public class CourseTwo {
    public static void main(String[] ar) {
        List<Peach> inventory=Arrays.asList(
                new Peach(80,"green"),
                new Peach(155,"green"),
                new Peach(120,"red")
        );

        List<Peach> greenPeach=filterPeachByGreen(inventory);
        System.out.println(greenPeach);

        List<Peach> greenPeach2=filterPeachByColor(inventory,"green");
        System.out.println(greenPeach2);

        List<Peach> greenPeach3=filterPeachByColor(inventory,"red");
        System.out.println(greenPeach3);

        List<Peach> greenPeach4=filter(inventory,new PeachGreenPredicate());
        System.out.println(greenPeach4);

        List<Peach> heavyPeach=filter(inventory,new PeachWeightGreater150Predicate());
        System.out.println(heavyPeach);

        List<Peach> redAndHeavyApples=filter(inventory, new PeachRedAndHeavyPredicate());
        System.err.println(redAndHeavyApples);

        List<Peach> redPeach=filter(inventory, new PeachPredicate(){
            public boolean test(Peach p){
                return p.getColor().equals("red");
            }
        });
        System.out.println(redPeach);

    }

    /**
     * 过滤绿色的桃子
     * @param inventory
     * @return
     */
    public static List<Peach> filterPeachByGreen(List<Peach> inventory){
        List<Peach> list=new ArrayList<>();
        for(Peach p: inventory){
            if("green".equals(p.getColor())){
                list.add(p);
            }
        }
        return list;
    }

    /**
     * 通过颜色过滤桃子
     * @param inventory
     * @param color
     * @return
     */
    public static List<Peach> filterPeachByColor(List<Peach> inventory,String color){
        List<Peach> list=new ArrayList<>();
        for(Peach p:inventory){
            if(p.getColor().equals(color)){
                list.add(p);
            }
        }
        return list;
    }

    /**
     * 通过重量过滤桃子
     * @param inventory
     * @return
     */
    public static List<Peach> filterPeachByWeight(List<Peach> inventory,int weight){
        List<Peach> list=new ArrayList<>();
        for(Peach p:inventory){
            if(p.getWeight()>weight){
                list.add(p);
            }
        }
        return list;
    }

    /**
     * 过滤符合条件
     * @param inventory
     * @param peachPredicate
     * @return
     */
    public static List<Peach> filter(List<Peach> inventory,PeachPredicate peachPredicate){
        List<Peach> result=new ArrayList<>();
        for(Peach p:inventory){
            if(peachPredicate.test(p)){
                result.add(p);
            }
        }
        return result;
    }

}

/**
 * 桃子判断接口
 */
@FunctionalInterface
interface PeachPredicate {
    boolean test(Peach peach);
}

/**
 * 红色桃子
 */
class PeachRedAndHeavyPredicate implements PeachPredicate {
    @Override
    public boolean test(Peach peach) {
        return "red".equals(peach.getColor()) && peach.getWeight() > 80;
    }
}

/**
 * 绿色桃子
 */
class PeachGreenPredicate implements  PeachPredicate{

    @Override
    public boolean test(Peach peach) {
        return "green".equals(peach.getColor());
    }
}

/**
 * 大于150桃子
 */
class PeachWeightGreater150Predicate implements  PeachPredicate{

    @Override
    public boolean test(Peach peach) {
        return peach.getWeight()>150;
    }
}
