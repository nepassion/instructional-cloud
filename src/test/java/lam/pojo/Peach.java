package lam.pojo;

import java.util.Objects;

public class Peach {
    private int weight=0;
    private String color="";

    public Peach(int weight, String color) {
        this.weight = weight;
        this.color = color;
    }

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

    @Override
    public String toString() {
        return "Peach{" +
                "weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Peach peach = (Peach) o;
        return weight == peach.weight && Objects.equals(color, peach.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, color);
    }
}
