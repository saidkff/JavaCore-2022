package Generics;

public class GenericDemo {
    public static void main(String[] args) {
        List<String> list = new List<>(5);
        list.add("Hello");
        list.add("World");
        list.add("232");
        list.add("871e2");
        list.add("SomeWord");
        System.out.println(list.get(1));
    }
}
