package pl.jaz.jazapp.services.category;

import pl.jaz.jazapp.pojo.CategoryEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Optional;

public class CategorySearchService {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Optional<CategoryEntity> findCategory(String name) {
        return em.createQuery("from CategoryEntity where categoryName = :name", CategoryEntity.class)
                .setParameter("name", name)
                .getResultList().stream()
                .findFirst();
    }

    @Transactional
    public Optional<CategoryEntity> findCategories(String department_id) {
        return em.createQuery("from CategoryEntity where departmentId = :department_id", CategoryEntity.class)
                .setParameter("department_id", department_id)
                .getResultList().stream()
                .findFirst();
    }
}
