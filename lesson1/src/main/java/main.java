import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(arr));
        swap(arr, 1, 3);
        System.out.println(Arrays.toString(arr));

        zadanie2();
        zadanie3();

    }


    //Задание 1
    public static <T> void swap(T[] array, int firstIndex, int secondIndex) {
        if (firstIndex > array.length || secondIndex > array.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        T temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    //Задание 2
    public static void zadanie2() {
        String[] array = new String[]{"AB", "BC", "CD", "DE"};
        List list = new ArrayList<>();
        for (String s : array) {
            list.add(s);
        }
        System.out.println(list);
    }

    //Задание 3
    public static void zadanie3() {
        List<Integer> list = new ArrayList<>();
        Box<Orange> oranges = new Box<>(
                new Orange(),
                new Orange(),
                new Orange(),
                new Orange(),
                new Orange()
        );
        Box<Apple> apples = new Box<>(
                new Apple(),
                new Apple(),
                new Apple(),
                new Apple()
        );
        Box<GoldenApple> goldenAppleBox = new Box<>(
                new GoldenApple(),
                new GoldenApple(),
                new GoldenApple(),
                new GoldenApple(),
                new GoldenApple()
        );
        System.out.println(goldenAppleBox.getWeight());
        goldenAppleBox.moveTo(apples);
    }
}



