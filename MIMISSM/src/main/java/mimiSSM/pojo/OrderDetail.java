package mimiSSM.pojo;

/**
 * @author
 * @description:
 * @create 2022/6/23-22:15
 */
//订单类
public class OrderDetail {
    private Integer odid;//订单号
    private String oid;//订单编号
    private Integer pid;//商品id
    private Integer pnumber;//商品数量
    private Double ptotal;//总金额
    private String pName;//商品名

    public OrderDetail() {
    }

    public OrderDetail(Integer odid, String oid, Integer pid, Integer pnumber, Double ptotal, String pName) {
        this.odid = odid;
        this.oid = oid;
        this.pid = pid;
        this.pnumber = pnumber;
        this.ptotal = ptotal;
        this.pName = pName;
    }

    public Integer getOdid() {
        return odid;
    }

    public void setOdid(Integer odid) {
        this.odid = odid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getPnumber() {
        return pnumber;
    }

    public void setPnumber(Integer pnumber) {
        this.pnumber = pnumber;
    }

    public Double getPtotal() {
        return ptotal;
    }

    public void setPtotal(Double ptotal) {
        this.ptotal = ptotal;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "odid=" + odid +
                ", oid='" + oid + '\'' +
                ", pid=" + pid +
                ", pnumber=" + pnumber +
                ", ptotal=" + ptotal +
                ", pName='" + pName + '\'' +
                '}';
    }
}
