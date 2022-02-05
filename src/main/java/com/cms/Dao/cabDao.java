package com.cms.Dao;

import com.cms.Model.cabModel;

import java.util.Set;

public interface cabDao {
    Set<cabModel> getNoOfAvailableCabs() throws Exception;
}