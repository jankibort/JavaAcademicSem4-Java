package pl.jaz.jazapp.repositories;

import pl.jaz.jazapp.pojo.Auction;

import java.util.List;


public interface AuctionRepository {
    List<Auction> findAll();
}
