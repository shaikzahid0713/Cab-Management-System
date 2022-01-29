/* Cab Driver Requirements :-
   1. Attributes :
            Id, Name, Email, Department
   2. Methods :
            Raise a cab request.
            if rejected, can request again.
*/



package com.cms.Model;


public class cabModel {
    Integer cabId;
    Boolean isAvailable;

    public cabModel(Integer cabId){
        this.cabId = cabId;
        this.isAvailable = true;
    }

    public Integer getCabDriverId() {
        return cabId;
    }

    public void setCabDriverId(Integer cabId) {
        this.cabId = cabId;
    }


    @Override
    public String toString() {
        return "cabModel{" +
                "cabId=" + cabId +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
