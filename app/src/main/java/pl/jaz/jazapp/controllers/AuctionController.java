package pl.jaz.jazapp.controllers;

import pl.jaz.jazapp.pojo.AuctionEntity;
import pl.jaz.jazapp.pojo.CategoryEntity;
import pl.jaz.jazapp.requests.AuctionRequest;
import pl.jaz.jazapp.services.auction.AuctionCreatorService;
import pl.jaz.jazapp.services.auction.AuctionSearchService;
import pl.jaz.jazapp.services.category.CategorySearchService;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Named
@ApplicationScoped
public class AuctionController {
    @Inject
    AuctionCreatorService auctionCreator;
    @Inject
    AuctionSearchService auctionSearch;

    public String goToCreateAuction() {
        return "/app/auctions/edit.xhtml";
    }

    public List<AuctionEntity> getAllAuctions() {
        return auctionSearch.getAllAuctions();
    }

    public String createAuction(AuctionRequest auctionRequest) {
        auctionCreator.createAuction(auctionRequest);
        return "/app";
    }

    public String goToMyListing() { return "/app/auctions/mine.xhtml"; }

    public String goToAuctionList() { return "/app"; }
}
