package pl.jaz.jazapp.controllers;

import pl.jaz.jazapp.pojo.CategoryEntity;
import pl.jaz.jazapp.pojo.DepartmentEntity;
import pl.jaz.jazapp.requests.DepartmentRequest;
import pl.jaz.jazapp.requests.EditDepartmentRequest;
import pl.jaz.jazapp.services.department.DepartmentCreatorService;
import pl.jaz.jazapp.services.department.DepartmentSearchService;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static java.lang.Integer.parseInt;

@Named
@RequestScoped
public class DepartmentController {
    @Inject
    DepartmentCreatorService departmentCreator;
    @Inject
    DepartmentSearchService departmentSearch;
    @Inject
    EditDepartmentRequest editDepartmentRequest;
    @Inject
    HttpServletRequest params;

    public EditDepartmentRequest editDepartmentRequest() {
        if (editDepartmentRequest==null) {
            if (params.getParameter("departmentId") != null) {
                int departmentId = parseInt(params.getParameter("departmentId"));
                DepartmentEntity departmentEntity = departmentSearch.getDepartmentById(departmentId).get();
                editDepartmentRequest = new EditDepartmentRequest(departmentEntity);
            } else {
                editDepartmentRequest = new EditDepartmentRequest();
            }
        }
        return editDepartmentRequest;
    }

    public String goToDepartments() {
        return "/app/departments/list.xhtml?faces-redirect=true";
    }

    public String save(EditDepartmentRequest editDepartmentRequest) {
        departmentCreator.createDepartment(editDepartmentRequest);
        return "/departments/list.xhtml?faces-redirect=true";
    }

    public List<DepartmentEntity> getAllDepartments() {
        return departmentSearch.getAllDepartments();
    }

    public String add() { return "/app/departments/edit.xhtml"; }

    public String edit(int id) {
        return "/app/departments/edit.xhtml?departmentId=" + id + "&faces-redirect-true";
    }
}
