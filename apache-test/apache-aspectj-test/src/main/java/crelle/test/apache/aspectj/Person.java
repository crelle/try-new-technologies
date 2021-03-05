package crelle.test.apache.aspectj;

/**
 * @author:crelle
 * @className:Person
 * @version:1.0.0
 * @date:2021/3/5
 * @description:XX
 **/
public class Person {

    private String name;

    private String age;

    @CityAnno(prefix = "中国")
    private String city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
