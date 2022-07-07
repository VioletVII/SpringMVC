package Bean;

import java.util.List;

/**
 * @author
 * @description:
 * @create 2022/5/10-18:53
 */
public class Demptment {
    private int did;
    private String depName;
    private List<Employee> emps;

    public Demptment() {
    }

    public Demptment(int did, String depName) {
        this.did = did;
        this.depName = depName;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public List<Employee> getEmps() {
        return emps;
    }

    public void setEmps(List<Employee> emps) {
        this.emps = emps;
    }

    @Override
    public String toString() {
        return "Demptment{" +
                "did=" + did +
                ", depName='" + depName + '\'' +
                ", emps=" + emps +
                '}';
    }
}
