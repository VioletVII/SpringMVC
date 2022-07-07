package mimiSSM.pojo;

import java.sql.Date;

/**
 * @author
 * @description:
 * @create 2022/6/24-14:25
 */
//订单详细类
public class OrderTail {
    private String oid;
    private Integer uid;
    private Integer addressId;
    private Double totalprice;
    private String cnee;
    private String phone;
    private String remarks;
    private String status;
    private Date odate;

    public OrderTail() {
    }

    public OrderTail(String oid, Integer uid, Integer addressId, Double totalprice, String remarks, String status, Date odate) {
        this.oid = oid;
        this.uid = uid;
        this.addressId = addressId;
        this.totalprice = totalprice;
        this.remarks = remarks;
        this.status = status;
        this.odate = odate;
    }

    public OrderTail(String oid, Integer uid, Integer addressId, Double totalprice, String cnee, String phone, String remarks, String status, Date odate) {
        this.oid = oid;
        this.uid = uid;
        this.addressId = addressId;
        this.totalprice = totalprice;
        this.cnee = cnee;
        this.phone = phone;
        this.remarks = remarks;
        this.status = status;
        this.odate = odate;
    }

    public String getOid() {
        return oid;
    }

    public String getCnee() {
        return cnee;
    }

    public void setCnee(String cnee) {
        this.cnee = cnee;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public Double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Double totalprice) {
        this.totalprice = totalprice;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getOdate() {
        return odate;
    }

    public void setOdate(Date odate) {
        this.odate = odate;
    }

    @Override
    public String toString() {
        return "OrderTail{" +
                "oid='" + oid + '\'' +
                ", uid=" + uid +
                ", addressId=" + addressId +
                ", totalprice=" + totalprice +
                ", cnee='" + cnee + '\'' +
                ", phone='" + phone + '\'' +
                ", remarks='" + remarks + '\'' +
                ", status='" + status + '\'' +
                ", odate=" + odate +
                '}';
    }
}
