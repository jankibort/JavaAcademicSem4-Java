package pl.jaz.jazapp.services.category;

import pl.jaz.jazapp.pojo.CategoryEntity;
import pl.jaz.jazapp.pojo.DepartmentEntity;
import pl.jaz.jazapp.requests.AuctionRequest;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class CategoryCreatorService {
    @PersistenceContext
    private EntityManager em;
    @Inject
    AuctionRequest auctionRequest;

    @Transactional
    public void createCategory(String name, DepartmentEntity department_id) {
        var categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryName(name);
        categoryEntity.setDepartmentId(department_id);


        em.persist(categoryEntity);
    }
}
