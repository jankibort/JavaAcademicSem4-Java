package pl.jaz.jazapp.controllers;

import pl.jaz.jazapp.pojo.CategoryEntity;
import pl.jaz.jazapp.requests.AuctionRequest;
import pl.jaz.jazapp.services.auction.AuctionCreatorService;
import pl.jaz.jazapp.services.category.CategorySearchService;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Optional;

@Named
@ApplicationScoped
public class AuctionController {
    @Inject
    AuctionCreatorService auctionCreator;
//    @Inject
//    CategorySearchService categorySearch;

    public String goToCreateAuction() {
        return "/auctions/edit.xhtml";
    }

//    public Optional<CategoryEntity> getAllCategories() {
//        return categorySearch.getAllCategories();
//    }

    public String createAuction(AuctionRequest auctionRequest) {
        auctionCreator.createAuction(auctionRequest);
        return "/";
    }
}
