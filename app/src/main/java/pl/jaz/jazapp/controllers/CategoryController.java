package pl.jaz.jazapp.controllers;

import pl.jaz.jazapp.pojo.CategoryEntity;
import pl.jaz.jazapp.services.category.CategoryCreatorService;
import pl.jaz.jazapp.services.category.CategorySearchService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@RequestScoped
@Named
public class CategoryController {
    @Inject
    CategoryCreatorService categoryCreator;
    @Inject
    CategorySearchService categorySearch;

        public List<CategoryEntity> getAllCategories() {
        return categorySearch.getAllCategories();
    }

}
