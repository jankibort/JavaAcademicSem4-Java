package pl.jaz.jazapp.services.department;

import pl.jaz.jazapp.pojo.DepartmentEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Optional;

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
}