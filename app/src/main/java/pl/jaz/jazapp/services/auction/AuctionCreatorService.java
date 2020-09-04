package pl.jaz.jazapp.services.auction;

import pl.jaz.jazapp.UserContext;
import pl.jaz.jazapp.requests.AuctionRequest;
import pl.jaz.jazapp.pojo.AuctionEntity;
import pl.jaz.jazapp.services.user.UserSearchService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class AuctionCreatorService {
    @Inject
    UserContext userContext;
    @PersistenceContext
    private EntityManager em;
    @Inject
    UserSearchService userSearchService;

    @Transactional
    public void createAuction(AuctionRequest auctionRequest) {
        var auctionEntity = new AuctionEntity();
        auctionEntity.setTitle(auctionRequest.getTitle());
        auctionEntity.setDescription(auctionRequest.getDescription());
        auctionEntity.setPrice(auctionRequest.getPrice());
        auctionEntity.setCategoryId(auctionRequest.getCategory_id());
        auctionEntity.setOwnerId(userSearchService.getByUsername(userContext.getUsername()).get());
        auctionEntity.setVersion(auctionRequest.getVersion());

        em.persist(auctionEntity);
    }
}
