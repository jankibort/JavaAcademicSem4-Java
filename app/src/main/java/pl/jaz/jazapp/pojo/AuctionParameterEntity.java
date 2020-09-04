package pl.jaz.jazapp.pojo;

public class AuctionParameterEntity {
    private AuctionEntity auctionId;
    private ParameterEntity parameterId;
    private String value;

    public AuctionEntity getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(AuctionEntity auctionId) {
        this.auctionId = auctionId;
    }

    public ParameterEntity getParameterId() {
        return parameterId;
    }

    public void setParameterId(ParameterEntity parameterId) {
        this.parameterId = parameterId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
