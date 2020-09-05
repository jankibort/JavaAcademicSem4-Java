package pl.jaz.jazapp.services.category;

import pl.jaz.jazapp.pojo.CategoryEntity;
import pl.jaz.jazapp.pojo.DepartmentEntity;
import pl.jaz.jazapp.requests.AuctionRequest;
import pl.jaz.jazapp.requests.CategoryRequest;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Model
public class CategoryCreatorService {
    @PersistenceContext
    private EntityManager em;
    @Inject
    AuctionRequest auctionRequest;

    @Transactional
    public void createCategory(CategoryRequest categoryRequest) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryName(categoryRequest.getName());
        categoryEntity.setDepartmentId(categoryRequest.getDepartmentId());

        em.persist(categoryEntity);
    }
}
