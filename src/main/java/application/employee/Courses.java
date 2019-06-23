package application.employee;

import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Courses {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "courses_key")
    private int id;

    @Column(name = "courseName")
    private String name;

    @Column(name = "courseArea")
    private String area;

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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
