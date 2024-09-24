package lam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class CourseOne {
    public static void main(String[] args) {
        List<Pear> inventory= Arrays.asList(
                new Pear(80,"green"),
                new Pear(155,"green"),
                new Pear(120,"red")
                );
        List<Pear> greenPear=filterApples(inventory,CourseOne::isGreenPear);
        System.out.println(greenPear);
        CourseOne co=new CourseOne();
        List<Pear> heavyPear=filterApples(inventory,co::isHeavyPear);
        System.out.println(heavyPear);
    }

    public static boolean isGreenPear(Pear pear){
        return "green".equals(pear.getColor());
    }
    public boolean isHeavyPear(Pear pear){
        return pear.getWeight()>150;
    }

    public static List<Pear> filterApples(List<Pear> inventory, Predicate<Pear> p){
        List<Pear> result=new ArrayList<>();
        for(Pear pear:inventory){
            if(p.test(pear)){
                result.add(pear);
            }
        }
        return result;
    }

    public static class Pear{
        private int weight=0;
        private String color="";

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public Pear(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        @Override
        public String toString() {
            return "Pear{" +
                    "weight=" + weight +
                    ", color='" + color + '\'' +
                    '}';
        }
    }

}
