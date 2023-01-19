package ENUMS;

public class EnumDemo {
    public static void main(String[] args) {
        ProcessorType bit32 = ProcessorType.BIT_32;
        System.out.println(bit32);
        System.out.println(ProcessorType.BIT_32.name());
        System.out.println(ProcessorType.valueOf("BIT_32"));
        System.out.println(bit32.toString());
        System.out.println(bit32.getName());
        bit32.setName("HelloWorld!");
        System.out.println(bit32.getName());
        System.out.println(bit32.getDescription());
    }
}
