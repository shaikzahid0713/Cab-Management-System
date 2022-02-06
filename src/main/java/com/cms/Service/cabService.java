package com.cms.Service;

import com.cms.Model.cabModel;

import java.util.Set;

public interface cabService {
    Set<cabModel> getNoOfAvailableCabs() throws Exception;
}
