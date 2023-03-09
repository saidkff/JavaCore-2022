package ReflectionAPI.Annotation;
@MyAnnotation(name = "hello")
public class AnnotationDemo {
    @MyAnnotation(name = "Privet", age = 18)
    private int age;
    private String name;
    @MyAnnotation(name = "Privet")
    public AnnotationDemo(int age, String name) {
        this.age = age;
        this.name = name;
    }


    @MyAnnotation(name = "Privet", age = 18)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
