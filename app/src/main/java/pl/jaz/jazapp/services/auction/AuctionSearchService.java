package pl.jaz.jazapp.services.auction;

import pl.jaz.jazapp.UserContext;
import pl.jaz.jazapp.pojo.AuctionEntity;
import pl.jaz.jazapp.pojo.CategoryEntity;
import pl.jaz.jazapp.pojo.UserEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@ApplicationScoped
public class AuctionSearchService {
    @PersistenceContext
    private EntityManager em;
    @Inject
    UserContext userContext;

    @Transactional
    public Optional<AuctionEntity> findAuction(int id) {
        return em.createQuery("from AuctionEntity where id = :id", AuctionEntity.class)
                .setParameter("id", id)
                .getResultList().stream()
                .findFirst();
    }

    public List<AuctionEntity> getUserAuctions(Optional<UserEntity> idByUsername) {
        return em.createQuery("from AuctionEntity where ownerId = :ownerId", AuctionEntity.class)
                .setParameter("ownerId", userContext.getId())
                .getResultList();
    }

    public List<AuctionEntity> getAllAuctions() {
        return em.createQuery("FROM AuctionEntity ", AuctionEntity.class).getResultList();
    }
}
