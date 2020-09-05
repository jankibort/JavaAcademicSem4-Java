package pl.jaz.jazapp.services.auctionParameter;

import pl.jaz.jazapp.UserContext;
import pl.jaz.jazapp.pojo.AuctionEntity;
import pl.jaz.jazapp.pojo.AuctionParameterEntity;
import pl.jaz.jazapp.pojo.ParameterEntity;
import pl.jaz.jazapp.services.user.UserSearchService;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public class AuctionParameterCreatorService {
    @Inject
    UserContext userContext;
    @PersistenceContext
    private EntityManager em;
    @Inject
    UserSearchService userSearchService;

    @Transactional
    public void addParameter(AuctionEntity auctionEntity, ParameterEntity parameterEntity) {
        var auctionParameterEntity = new AuctionParameterEntity();
        auctionParameterEntity.setAuctionId(auctionEntity.getAuctionId());
        auctionParameterEntity.setParameterId(parameterEntity.getId());

    }
}
