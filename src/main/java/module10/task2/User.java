package module10.task2;

public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User {" +
                "name = '" + name + '\'' +
                "," + '\t' + "age = " + age +
                '}';
    }
}
