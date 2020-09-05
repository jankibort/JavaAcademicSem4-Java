package pl.jaz.jazapp.services.auction;

import pl.jaz.jazapp.pojo.AuctionEntity;
import pl.jaz.jazapp.pojo.CategoryEntity;
import pl.jaz.jazapp.pojo.UserEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@ApplicationScoped
public class AuctionSearchService {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Optional<AuctionEntity> findAuction(int id) {
        return em.createQuery("from AuctionEntity where id = :id", AuctionEntity.class)
                .setParameter("id", id)
                .getResultList().stream()
                .findFirst();
    }

    public List<AuctionEntity> getAllAuctions() {
        return em.createQuery("FROM AuctionEntity ", AuctionEntity.class).getResultList();
    }
}
