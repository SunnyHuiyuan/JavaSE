/**
 * demo
 */

public class Helloworld {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.setAge(18);
        cat.setName("张三");
        int age = cat.getAge();
        String name = cat.getName();
        System.out.println("name:" + name + '\n' + "age:" + age);
    }
}

/*
 * 定义一个Cat封装类
 * */
class Cat {
    // 定义私有变量age 和name
    private int age;
    private String name;

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

    @Override
    public String toString() {
        return "Cat{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public Cat() {
    }

    public Cat(int age, String name) {
        this.age = age;
        this.name = name;
    }
}