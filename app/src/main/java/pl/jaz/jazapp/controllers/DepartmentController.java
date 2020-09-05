package pl.jaz.jazapp.controllers;

import pl.jaz.jazapp.pojo.CategoryEntity;
import pl.jaz.jazapp.pojo.DepartmentEntity;
import pl.jaz.jazapp.requests.DepartmentRequest;
import pl.jaz.jazapp.services.department.DepartmentCreatorService;
import pl.jaz.jazapp.services.department.DepartmentSearchService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Named
@ApplicationScoped
public class DepartmentController {
    @Inject
    DepartmentCreatorService departmentCreator;
    @Inject
    DepartmentSearchService departmentSearch;

    protected Optional<DepartmentEntity> getDepartmentById(HttpServletRequest req) throws IOException {
        var departmentId = req.getParameter("departmentId");
        return departmentSearch.findDepartmentById(departmentId);
    }

    public String goToDepartments() {
        return "/app/departments/list.xhtml";
    }

    public String save(DepartmentRequest departmentRequest) {
        departmentCreator.createDepartment(departmentRequest.getName());
        return "/app/departments/list.xhtml";
    }

    public List<DepartmentEntity> getAllDepartments() {
        return departmentSearch.getAllDepartments();
    }

    public String add() { return "/app/departments/edit.xhtml"; }

    public String edit(int id) {
        return "/app/departments/edit.xhtml?departmentId=" + id + "&faces-redirect-true";
    }
}
