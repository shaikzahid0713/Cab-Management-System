package com.cms.Exception;

public class cabNotAvailable extends Exception{

    public cabNotAvailable(String str) {
        super(str);
    }
    @Override
    public String getMessage () {
        return "Booking Closed....";
    }

    @Override
    public String toString () {
        return "No Cab Available. Try Again....";
    }
}
