package pl.jaz.jazapp.services.category;

import pl.jaz.jazapp.pojo.CategoryEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Model
@ApplicationScoped
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
    public List<CategoryEntity> getAllCategories() {
     return em.createQuery("FROM CategoryEntity", CategoryEntity.class).getResultList();
    }
}
