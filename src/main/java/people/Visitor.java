package people;
import attractions.Attraction;
import java.util.ArrayList;

public class Visitor {
    private ArrayList<Attraction> visitedAttractions;
    private int age;
    private double height;
    private double money;

    public Visitor(int age, double height, double money) {
        this.age = age;
        this.height = height;
        this.money = money;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    public double getMoney() {
        return money;
    }

    public void addAttraction(Attraction attraction){
        this.visitedAttractions.add(attraction);
    }
}
