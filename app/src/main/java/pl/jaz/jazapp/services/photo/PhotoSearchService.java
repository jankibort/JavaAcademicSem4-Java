package pl.jaz.jazapp.services.photo;

import pl.jaz.jazapp.pojo.AuctionEntity;
import pl.jaz.jazapp.pojo.DepartmentEntity;
import pl.jaz.jazapp.pojo.PhotoEntity;
import pl.jaz.jazapp.requests.AuctionRequest;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Model
@ApplicationScoped
public class PhotoSearchService {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public List<PhotoEntity> getPhotoByAuction(int auctionId) {
        return em.createQuery("from PhotoEntity where auctionId = :auctionId order by id", PhotoEntity.class)
                .setParameter("auctionId", auctionId)
                .getResultList();
    }
}
