package pl.jaz.jazapp.requests;

import pl.jaz.jazapp.pojo.DepartmentEntity;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import java.io.Serializable;

@SessionScoped
@Model
public class EditDepartmentRequest implements Serializable {
    int departmentId;
    String name;

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EditDepartmentRequest(){}

    public EditDepartmentRequest(DepartmentEntity departmentEntity) {
        this.departmentId = departmentEntity.getDepartmentId();
        this.name = departmentEntity.getName();
    }
}
