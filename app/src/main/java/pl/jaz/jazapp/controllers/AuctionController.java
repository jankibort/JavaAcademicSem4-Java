package pl.jaz.jazapp.controllers;

import ch.qos.logback.core.pattern.parser.OptionTokenizer;
import pl.jaz.jazapp.UserContext;
import pl.jaz.jazapp.pojo.*;
import pl.jaz.jazapp.requests.AuctionRequest;
import pl.jaz.jazapp.services.auction.AuctionCreatorService;
import pl.jaz.jazapp.services.auction.AuctionSearchService;
import pl.jaz.jazapp.services.category.CategorySearchService;
import pl.jaz.jazapp.services.parameter.ParameterSearchService;
import pl.jaz.jazapp.services.photo.PhotoSearchService;
import pl.jaz.jazapp.services.user.UserSearchService;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Named
@ApplicationScoped
public class AuctionController {
    @Inject
    AuctionCreatorService auctionCreator;
    @Inject
    AuctionSearchService auctionSearch;
    @Inject
    PhotoSearchService photoSearch;
    @Inject
    UserSearchService userSearchService;
    @Inject
    UserContext userContext;
//    @Inject
//    ParameterSearchService parameterSearchService;

    public String goToCreateAuction() {
        return "/app/auctions/edit.xhtml?faces-redirect=true";
    }

//    public List<AuctionMerge> getAuctionList() {
//        List<AuctionMerge> mergedAuctions = new ArrayList<>();
//        auctionSearch.getUserAuctions(userSearchService.getIdByUsername(userContext.getUsername())).forEach(auction -> {
//            List<AuctionParameterEntity> auction_parameters = auction_parametersSearchService.getAuction_parametersByAuctionId(auction.getId());
//
//            List<ParameterEntity> params = new ArrayList<>();
//            params.add(parameterSearchService.getParameterById(auction_parameters.get(2).getParameter_id()).get());
//            params.add(parameterSearchService.getParameterById(auction_parameters.get(1).getParameter_id()).get());
//            params.add(parameterSearchService.getParameterById(auction_parameters.get(0).getParameter_id()).get());
//
//            mergedAuctions.add(new AuctionMerge(auction, photoSearch.getPhotoByAuction(auction.getAuctionId()), auction_parameters, params));
//        });
//
//        return mergedAuctions;
//    }

    public List<AuctionEntity> getAllAuctions() {
        return auctionSearch.getAllAuctions();
    }

    public String createAuction(AuctionRequest auctionRequest) {
        auctionCreator.createAuction(auctionRequest);
        return "/app";
    }

    public String goToMyListing() {
        return "/app/auctions/mine.xhtml?faces-redirect=true";
    }

    public String goToAuctionList() {
        return "/app?faces-redirect=true";
    }
}
