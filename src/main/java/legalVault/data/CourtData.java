package legalVault.data;

public class CourtData {
    private Integer courtId;
    private String courtAddress;

    public CourtData(Integer courtId, String courtAddress) {
        this.courtId = courtId;
        this.courtAddress = courtAddress;
    }

    public Integer getCourtId() {
        return courtId;
    }

    public String getCourtAddress() {
        return courtAddress;
    }
}
