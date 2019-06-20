package com.ecust.utms.model;

public class SimilarRateCheck {

    private Integer SRCID;//查重审核ID
    private Integer ThesisID;//论文ID
    private Integer Review;//审核状态
    private Float SDimilarRate;//查重率
    private String ReviewerID;//审核人ID

    public Integer getSRCID() {
        return SRCID;
    }

    public void setSRCID(Integer SRCID) {
        this.SRCID = SRCID;
    }

    public Integer getThesisID() {
        return ThesisID;
    }

    public void setThesisID(Integer thesisID) {
        ThesisID = thesisID;
    }

    public Integer getReview() {
        return Review;
    }

    public void setReview(Integer review) {
        Review = review;
    }

    public Float getSDimilarRate() {
        return SDimilarRate;
    }

    public void setSDimilarRate(Float SDimilarRate) {
        this.SDimilarRate = SDimilarRate;
    }

    public String getReviewerID() {
        return ReviewerID;
    }

    public void setReviewerID(String reviewerID) {
        ReviewerID = reviewerID;
    }
}
