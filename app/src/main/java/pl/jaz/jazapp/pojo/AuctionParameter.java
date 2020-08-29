package pl.jaz.jazapp.pojo;

public class AuctionParameter {
    private Auction auctionId;
    private Parameter parameterId;
    private String value;

    public Auction getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Auction auctionId) {
        this.auctionId = auctionId;
    }

    public Parameter getParameterId() {
        return parameterId;
    }

    public void setParameterId(Parameter parameterId) {
        this.parameterId = parameterId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
