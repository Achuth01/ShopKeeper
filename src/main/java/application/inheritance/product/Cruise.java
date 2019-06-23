package application.inheritance.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name = "Cruise")
@PrimaryKeyJoinColumn(name = "cruisePrimaryKey")
public class Cruise extends Product {

    @Column(name = "cruiseName")
    private String cruiseName;

    @Column(name = "cruiseId")
    private String cruiseId;

    public String getCruiseName() {
        return cruiseName;
    }

    public void setCruiseName(String cruiseName) {
        this.cruiseName = cruiseName;
    }

    public String getCruiseId() {
        return cruiseId;
    }

    public void setCruiseId(String cruiseId) {
        this.cruiseId = cruiseId;
    }
}
