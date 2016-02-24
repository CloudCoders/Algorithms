import eda.linear.ArrayQeue;

public class Main {
    public static void main(String[] args) {
        ArrayQeue<Integer> array = new ArrayQeue<>(10);
        System.out.println(array.isEmpty());
        array.add(1);
        array.add(2);
        array.add(3);
        System.out.println(array.toString());
        array.poll();
        System.out.println(array.toString());
        System.out.println(array.peek());
    }
}
