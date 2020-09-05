package pl.jaz.jazapp.requests;

import pl.jaz.jazapp.pojo.DepartmentEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class CategoryRequest {
    private int id;
    private String name;
    private DepartmentEntity departmentId;

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

    public DepartmentEntity getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(DepartmentEntity departmentId) {
        this.departmentId = departmentId;
    }
}
