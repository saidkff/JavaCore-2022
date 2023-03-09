package ReflectionAPI.Annotation;

public class AnnotationMainDemo {
    public static void main(String[] args) {
        AnnotationDemo murod = new AnnotationDemo(16, "Murod");
        Class<? extends AnnotationDemo> murodClass = murod.getClass();
        System.out.println();
    }
}
