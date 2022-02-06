package com.cms.Service;

import com.cms.Dao.cabDao;
import com.cms.Dao.cabDaoImpl;
import com.cms.Model.cabModel;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;

public class cabServiceImpl implements cabService{
    private static final Logger log = Logger.getLogger("cabServiceImpl.class");
    Set<cabModel> cabService = new LinkedHashSet<>();

    @Override
    public Set<cabModel> getNoOfAvailableCabs () throws Exception {
        log.info("Cab Service Implementation Class Called....");
        cabDao cabD = new cabDaoImpl();
        cabService = cabD.getNoOfAvailableCabs();
        return cabService;
    }
}

