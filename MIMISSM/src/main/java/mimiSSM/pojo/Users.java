package mimiSSM.pojo;

/**
 * @author
 * @description:
 * @create 2022/6/24-15:58
 */
public class Users {
    private Integer uid;//用户id
    private String uname;//用户名
    private String upass;//用户密码
    private Integer ustatus;//下单状态
    private Integer ulevel;//级别
    private Integer score;//积分

    public Users() {
    }

    public Users(Integer uid, String uname, String upass, Integer ustatus, Integer ulevel, Integer score) {
        this.uid = uid;
        this.uname = uname;
        this.upass = upass;
        this.ustatus = ustatus;
        this.ulevel = ulevel;
        this.score = score;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpass() {
        return upass;
    }

    public void setUpass(String upass) {
        this.upass = upass;
    }

    public Integer getUstatus() {
        return ustatus;
    }

    public void setUstatus(Integer ustatus) {
        this.ustatus = ustatus;
    }

    public Integer getUlevel() {
        return ulevel;
    }

    public void setUlevel(Integer ulevel) {
        this.ulevel = ulevel;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Users{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upass='" + upass + '\'' +
                ", ustatus=" + ustatus +
                ", ulevel=" + ulevel +
                ", score=" + score +
                '}';
    }
}
