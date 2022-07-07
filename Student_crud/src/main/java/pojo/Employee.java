package pojo;

public class Employee {

    private Integer id;
    private String empName;
    private Integer age;
    private String email;
    private Integer did;

    public Employee() {
    }

    public Employee(Integer id, String empName, Integer age, String email) {
        this.id = id;
        this.empName = empName;
        this.age = age;
        this.email = email;
    }

    public Employee(Integer id, String empName, Integer age, String email, Integer did) {
        this.id = id;
        this.empName = empName;
        this.age = age;
        this.email = email;
        this.did = did;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getEmpName() {
        return empName;
    }
    public void setEmpName(String empName) {
        this.empName = empName == null ? null : empName.trim();
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }
    public Integer getDid() {
        return did;
    }
    public void setDid(Integer did) {
        this.did = did;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", empName='" + empName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", did=" + did +
                '}';
    }
}