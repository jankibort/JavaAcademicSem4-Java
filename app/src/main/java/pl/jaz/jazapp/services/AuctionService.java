package pl.jaz.jazapp.services;

import pl.jaz.jazapp.pojo.Auction;
import pl.jaz.jazapp.repositories.AuctionRepository;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class AuctionService {
    AuctionRepository ar;
    public List<Auction> findAllAuctions() {
        return ar.findAll();
    }
}
