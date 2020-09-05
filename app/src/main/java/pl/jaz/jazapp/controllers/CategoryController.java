package pl.jaz.jazapp.controllers;

import pl.jaz.jazapp.pojo.CategoryEntity;
import pl.jaz.jazapp.requests.CategoryRequest;
import pl.jaz.jazapp.services.category.CategoryCreatorService;
import pl.jaz.jazapp.services.category.CategorySearchService;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@RequestScoped
@Model
public class CategoryController {
    @Inject
    CategoryCreatorService categoryCreator;
    @Inject
    CategorySearchService categorySearch;

    public List<CategoryEntity> getAllCategories() {
        return categorySearch.getAllCategories();
    }

    public String save(CategoryRequest categoryRequest) {
        categoryCreator.createCategory(categoryRequest);
        return "/app/categories/list.xhtml";
    }

    public String add() { return "/app/categories/edit.xhtml?faces-redirect=true"; }

    public String edit(int id) {
        return "/app/categories/edit.xhtml?departmentId=" + id + "&faces-redirect-true";
    }

    public String goToCategories() {
        return "/app/categories/list.xhtml?faces-redirect=true";
    }
}
