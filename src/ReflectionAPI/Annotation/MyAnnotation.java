package ReflectionAPI.Annotation;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.TYPE, ElementType.CONSTRUCTOR, ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
public @interface MyAnnotation {
    String name();
    int age() default 18;
}
