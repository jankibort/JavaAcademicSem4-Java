package pl.jaz.jazapp.pojo;

import javax.enterprise.context.SessionScoped;

import java.io.Serializable;
import java.util.List;

@SessionScoped
public class AuctionMerge implements Serializable {

    AuctionEntity auction;
    List<PhotoEntity> photos;
    List<AuctionParameterEntity> auction_params;
    List<ParameterEntity> params;

    public AuctionMerge() {

    }

    public AuctionMerge(AuctionEntity auction, List<PhotoEntity> photos, List<AuctionParameterEntity> auction_params, List<ParameterEntity> params) {
        this.auction = auction;
        this.photos = photos;
        this.auction_params = auction_params;
        this.params = params;
    }

    public int getId() {
        return auction.getAuctionId();
    }

    public String getTitle() {
        return auction.getTitle();
    }

    public String getDescription() {
        return auction.getDescription();
    }

    public int getPrice() {
        return auction.getPrice();
    }

    public String getCategory() {
        return auction.getCategoryId().toString();
    }

    public String getPhoto1() {
        return photos.get(0).getUrl();
    }

    public String getPhoto2() {
        return photos.get(1).getUrl();
    }

    public String getPhoto3() {
        return photos.get(2).getUrl();
    }

    public String getParam1() {
        return params.get(0).getName();
    }
}