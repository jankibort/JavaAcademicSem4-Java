package pl.jaz.jazapp.services.auctionParameter;

import pl.jaz.jazapp.UserContext;
import pl.jaz.jazapp.pojo.AuctionEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class AuctionParameterSearchService {
    @PersistenceContext
    private EntityManager em;
    @Inject
    UserContext userContext;


}