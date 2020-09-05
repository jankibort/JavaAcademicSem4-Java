package pl.jaz.jazapp.services.department;

import pl.jaz.jazapp.pojo.CategoryEntity;
import pl.jaz.jazapp.pojo.DepartmentEntity;

import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Model
public class DepartmentSearchService {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Optional<DepartmentEntity> findDepartment(String name) {
        return em.createQuery("from DepartmentEntity where name = :name", DepartmentEntity.class)
                .setParameter("name", name)
                .getResultList().stream()
                .findFirst();
    }

    @Transactional
    public Optional<DepartmentEntity> getDepartmentById(String id) {
        return em.createQuery("from DepartmentEntity where id = :id", DepartmentEntity.class)
                .setParameter("id", id)
                .getResultList().stream()
                .findFirst();
    }

    @Transactional
    public List<DepartmentEntity> getAllDepartments() {
        return em.createQuery("FROM DepartmentEntity ", DepartmentEntity.class).getResultList();
    }
}