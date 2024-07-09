package legalVault.data;

public class CaseData {
    private String caseId;
    private String courtId;
    private String prosecutorId;
    private String defenseId;
    private String judgeId;
    private String status;
    private String startDate;
    private String endDate;
    private String nextHearing;
    private String offenseId;

    public CaseData(String caseId, String courtId, String prosecutorId, String defenseId, String judgeId, String status, String startDate, String endDate, String nextHearing, String offenseId) {
        this.caseId = caseId;
        this.courtId = courtId;
        this.prosecutorId = prosecutorId;
        this.defenseId = defenseId;
        this.status = status;
        this.judgeId = judgeId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.nextHearing = nextHearing;
        this.offenseId = offenseId;
    }

    public String getCaseId() {
        return caseId;
    }

    public void setCaseId(String caseId) {
        this.caseId = caseId;
    }

    public String getCourtId() {
        return courtId;
    }

    public void setCourtId(String courtId) {
        this.courtId = courtId;
    }

    public String getProsecutorId() {
        return prosecutorId;
    }

    public void setProsecutorId(String prosecutorId) {
        this.prosecutorId = prosecutorId;
    }

    public String getDefenseId() {
        return defenseId;
    }

    public void setDefenseId(String defenseId) {
        this.defenseId = defenseId;
    }

    public String getJudgeId() {
        return judgeId;
    }

    public void setJudgeId(String judgeId) {
        this.judgeId = judgeId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getNextHearing() {
        return nextHearing;
    }

    public void setNextHearing(String nextHearing) {
        this.nextHearing = nextHearing;
    }

    public String getOffenseId() {
        return offenseId;
    }

    public void setOffenseId(String offenseId) {
        this.offenseId = offenseId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
