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
    public void createDepartment(EditDepartmentRequest editDepartmentRequest) {
        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setName(editDepartmentRequest.getName());
        if (editDepartmentRequest.getDepartmentId() == departmentEntity.getDepartmentId() || editDepartmentRequest.getName().equals(departmentEntity.getName())) {
            em.merge(departmentEntity);
        } else {
            em.persist(departmentEntity);
        }
    }
}
