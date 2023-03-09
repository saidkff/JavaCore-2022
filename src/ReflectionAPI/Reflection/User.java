package ReflectionAPI.Reflection;

public class User extends Person{
    private String name;
    public User(int ID, String name) {
        super(ID);
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                    "ID=" + getID()+
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
