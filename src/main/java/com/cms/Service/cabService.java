package com.cms.Service;

public interface cabService {

    // Employee Operations
    void raiseCabRequest();
    default void checkCabRequests() {}

    // Manager Operations
     default void approveOrRejectCabRequest() {}

    //Admin Operations
    default void addEmployee() {}
    default void addCab() {}
}
