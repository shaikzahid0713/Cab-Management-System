package com.cms.Service;

import java.util.logging.Logger;

public class cabServiceImpl implements cabService{

    private static final Logger log = Logger.getLogger("cabServiceImpl.class");

    @Override
    public void raiseCabRequest() {

    }

    @Override
    public void checkCabRequests() {

    }


    @Override
    public void approveOrRejectCabRequest() {

    }

    @Override
    public void addEmployee() {
        System.out.println("=== Employee Menu ===");
        System.out.println("1. Request a Cab ");
        System.out.println("2. Check Cab Requests");
        System.out.println("3. Book a Cab");

    }

    @Override
    public void addCab() {

    }
}

