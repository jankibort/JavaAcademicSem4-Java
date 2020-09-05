package pl.jaz.jazapp.pojo;

import javax.persistence.*;

@Entity
@Table(name="photo")
public class PhotoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String url;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="auction_id")
    private AuctionEntity auctionId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public AuctionEntity getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(AuctionEntity auctionId) {
        this.auctionId = auctionId;
    }
}
