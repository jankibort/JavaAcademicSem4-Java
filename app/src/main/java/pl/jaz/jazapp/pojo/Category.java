package pl.jaz.jazapp.pojo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int categoryId; //klucz glowny - categoryId

    @Column(name="name")
    private String categoryName;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="dapertment_id")
    private List<Department> departmentId = new ArrayList<>();

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Department> getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(List<Department> departmentId) {
        this.departmentId = departmentId;
    }
}
