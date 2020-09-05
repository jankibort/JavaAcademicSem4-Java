package pl.jaz.jazapp.requests;

import org.hibernate.sql.DerbyCaseFragment;
import pl.jaz.jazapp.pojo.CategoryEntity;
import pl.jaz.jazapp.pojo.DepartmentEntity;

public class EditCategoryRequest {
    int categoryId;
    String name;
    DepartmentEntity departmentId;

    public EditCategoryRequest(CategoryEntity categoryEntity) {
        this.categoryId = categoryEntity.getCategoryId();
        this.name = categoryEntity.getCategoryName();
        this.departmentId = categoryEntity.getDepartmentId();
    }
}
