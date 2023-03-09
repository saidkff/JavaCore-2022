package ReflectionAPI.Reflection;

import java.lang.reflect.*;

public class ReflectionAPIDemo {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        User user = new User(1, "Zhavokhir");
//        demoFields(user);
        demoMethods(user);
    }

    public static void testConstructor() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<User> constructor = User.class.getConstructor(int.class, String.class);
        User user = constructor.newInstance(1, "Bobur");
        System.out.println(user);
    }

    public static void demoFields(Object object) throws IllegalAccessException {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            boolean aPrivate = Modifier.isPrivate(field.getModifiers());
            System.out.println(aPrivate);
            System.out.println(field.get(object));
        }
    }

    public static void demoMethods(User user) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = User.class.getMethod("setName", String.class);
        method.invoke(user, "Murod");
        System.out.println(user);

//        Method method = User.class.getMethod("getName");
//        Object invoke = method.invoke(user);
//        System.out.println(invoke);

//        Method[] methods = User.class.getDeclaredMethods();
//        for (Method method : methods) {
//            System.out.println(method);
//        }
    }
}