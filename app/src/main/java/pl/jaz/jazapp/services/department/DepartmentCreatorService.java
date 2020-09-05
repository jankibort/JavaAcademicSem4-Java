package pl.jaz.jazapp.services.department;

import pl.jaz.jazapp.pojo.DepartmentEntity;
import pl.jaz.jazapp.requests.EditDepartmentRequest;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class DepartmentCreatorService {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void createDepartment(String name) {
        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setName(name);

//        if(departmentEntity.getD)
        em.persist(departmentEntity);
    }
}
