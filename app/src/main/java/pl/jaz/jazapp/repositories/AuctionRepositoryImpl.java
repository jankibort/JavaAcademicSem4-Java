package pl.jaz.jazapp.repositories;

import pl.jaz.jazapp.pojo.Auction;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class AuctionRepositoryImpl implements AuctionRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Auction> findAll() {
       Query query =  em.createQuery("SELECT e FROM Auction e");
        return (List<Auction>)query.getResultList();
    }
}
