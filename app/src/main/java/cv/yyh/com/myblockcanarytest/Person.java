package cv.yyh.com.myblockcanarytest;

/**
 * Created by Administrator on 2017/4/16 0016.
 */
public class Person {
    String name;
    private int  age;
    private String classes;

    public Person(String name, String classes, int age) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }
}
