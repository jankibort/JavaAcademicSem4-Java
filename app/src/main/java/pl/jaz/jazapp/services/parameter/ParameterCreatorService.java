package pl.jaz.jazapp.services.parameter;

import pl.jaz.jazapp.UserContext;
import pl.jaz.jazapp.pojo.AuctionEntity;
import pl.jaz.jazapp.pojo.AuctionParameterEntity;
import pl.jaz.jazapp.pojo.ParameterEntity;
import pl.jaz.jazapp.services.user.UserSearchService;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public class ParameterCreatorService {
    @Inject
    UserContext userContext;
    @PersistenceContext
    private EntityManager em;
    @Inject
    UserSearchService userSearchService;

//    @Transactional
//    public void addParameter(AuctionEntity auctionEntity, ParameterEntity parameterEntity) {
//        AuctionParameterEntity auctionParameterEntity = new AuctionParameterEntity();
//        auctionParameterEntity.setAuctionId(auctionEntity.getAuctionId());
//        auctionParameterEntity.setParameterId(parameterEntity.getId());
//
//    }
}
