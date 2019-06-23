package application.inheritance.product;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "car")
@PrimaryKeyJoinColumn(name = "carId",referencedColumnName = "product_Id")
public class Car extends Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "driverName")
    private String driverName;

    @Column(name = "driverNum")
    private String driverNum;

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverNum() {
        return driverNum;
    }

    public void setDriverNum(String driverNum) {
        this.driverNum = driverNum;
    }
}
