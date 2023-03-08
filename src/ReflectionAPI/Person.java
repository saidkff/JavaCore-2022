package ReflectionAPI;

public class Person {
    private int ID;

    public Person(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "Person{" +
                " ID=" + ID +
                '}';
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
