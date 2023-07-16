package pms;

import java.sql.Date;

public class Product {

    private int pid;
    private String pname;
    private double price;
    private Date DOM;

    public Product() {

    }

    public int getPid() {
        return pid;
    }

    public void setPID(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double d) {
        this.price = d;
    }

    public Date getDOM() {
        return DOM;
    }

    public void setDOM(Date dOM) {
        DOM = dOM;
    }

    public String toString() {
        return "[Product Id : "+getPid()+" Product Name : "+getPname()+" Price : "+getPrice()+" Date Of Manufacture : "+getDOM()+"]";
    }
}
