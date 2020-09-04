package pl.jaz.jazapp.controllers;

import pl.jaz.jazapp.requests.AuctionRequest;
import pl.jaz.jazapp.services.auction.AuctionCreatorService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class AuctionController {
    @Inject
    AuctionCreatorService auctionCreator;

    public String goToCreateAuction() {
        return "/auctions/edit.xhtml";
    }

    public String createAuction(AuctionRequest auctionRequest) {
        auctionCreator.createAuction(auctionRequest);
        return "/";
    }
}
