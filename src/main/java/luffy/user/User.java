package luffy.user;

import java.util.Date;

/**
 * Created by luffy on 2017/7/17.
 */
public class User {

    private int id;
    private String name;
    private String phone;
    private String city;
    private String address;
    private boolean isYixia;
    private Date createAt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isYixia() {
        return isYixia;
    }

    public void setYixia(boolean yixia) {
        isYixia = yixia;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return "user : id = "+this.id+",name = "+name;
    }
}
