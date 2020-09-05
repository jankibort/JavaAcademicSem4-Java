package pl.jaz.jazapp.services.photo;

import pl.jaz.jazapp.pojo.AuctionEntity;
import pl.jaz.jazapp.pojo.DepartmentEntity;
import pl.jaz.jazapp.pojo.PhotoEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Model;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
@Model
public class PhotoCreatorService {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void addPhoto(String url, AuctionEntity auctionId) {
        PhotoEntity PhotoEntity = new PhotoEntity();
        PhotoEntity.setUrl(url);
        PhotoEntity.setAuctionId(auctionId);

        em.persist(PhotoEntity);
    }
}
