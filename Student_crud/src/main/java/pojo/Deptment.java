package pojo;

public class Deptment {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_dept.did
     *
     * @mbggenerated Thu May 19 15:48:32 CST 2022
     */
    private Integer did;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_dept.dep_name
     *
     * @mbggenerated Thu May 19 15:48:32 CST 2022
     */
    private String depName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_dept.did
     *
     * @return the value of t_dept.did
     *
     * @mbggenerated Thu May 19 15:48:32 CST 2022
     */
    public Integer getDid() {
        return did;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_dept.did
     *
     * @param did the value for t_dept.did
     *
     * @mbggenerated Thu May 19 15:48:32 CST 2022
     */
    public void setDid(Integer did) {
        this.did = did;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_dept.dep_name
     *
     * @return the value of t_dept.dep_name
     *
     * @mbggenerated Thu May 19 15:48:32 CST 2022
     */
    public String getDepName() {
        return depName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_dept.dep_name
     *
     * @param depName the value for t_dept.dep_name
     *
     * @mbggenerated Thu May 19 15:48:32 CST 2022
     */
    public void setDepName(String depName) {
        this.depName = depName == null ? null : depName.trim();
    }

    public Deptment() {
    }

    public Deptment(Integer did, String depName) {
        this.did = did;
        this.depName = depName;
    }

    @Override
    public String toString() {
        return "Deptment{" +
                "did=" + did +
                ", depName='" + depName + '\'' +
                '}';
    }
}