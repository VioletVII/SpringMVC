package Bean;

import java.io.Serializable;

/**
 * @author
 * @description:
 * @create 2022/5/10-18:52
 */
public class Employee implements Serializable {
    private int id;
    private String empName;
    private int age;
    private String email;
    private Demptment demp;

    public Employee() {
    }
    public Employee(int id, String empName, int age, String email) {
        this.id = id;
        this.empName = empName;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Demptment getDemp() {
        return demp;
    }

    public void setDemp(Demptment demp) {
        this.demp = demp;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", empName='" + empName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", demp=" + demp +
                '}';
    }
}
