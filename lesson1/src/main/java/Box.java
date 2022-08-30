import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box<T extends Fruit> {

    private List<T> friuts;

    public Box(T... fruits) {
        this.friuts = new ArrayList<>(Arrays.asList(fruits));
    }

    double getWeight() {
        double sum = 0.0;
        for (T friut : friuts){
            sum+= friut.getWeight();
        }
        return sum;
    }

    void addAll(List<? extends T> fruits) {
        friuts.addAll(fruits);
    }

    void moveTo(Box<? super T> box) {
        box.addAll(friuts);
        friuts.clear();

    }

}
