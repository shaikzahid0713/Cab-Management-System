package com.cms.Model;

public class cabModel {

    private Integer cabId;
    private Boolean isAvailable;

    public cabModel (Integer cabId) {
        this.cabId = cabId;
        this.isAvailable = true;
    }

    public Integer getCabDriverId () {
        return cabId;
    }

    public void setCabDriverId (Integer cabId) {
        this.cabId = cabId;
    }


    public Boolean getAvailable () {
        return isAvailable;
    }

    public void setAvailable (Boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString () {
        return "cabModel{" +
                "cabId=" + cabId +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
