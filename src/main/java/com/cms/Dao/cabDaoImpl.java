package com.cms.Dao;

import com.cms.Model.cabModel;
import com.cms.db.databaseConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.logging.Logger;

public class cabDaoImpl implements cabDao {
    private static final Logger log = Logger.getLogger("cabDaoImpl.class");
    Set<cabModel> cabSet = new LinkedHashSet<>();

    @Override
    public Set<cabModel> getNoOfAvailableCabs () throws Exception {
        log.info("Cab Dao Impl Class Called....");

        try {
            Connection connect = databaseConnect.getConnection();
            PreparedStatement ps = connect.prepareStatement("select CID from cabs");
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Integer cabNo = rs.getInt(1);
                int cabStatus = rs.getInt(2);
                cabModel cab = new cabModel(cabNo);
                if (cabStatus == 0) cab.setAvailable(false);
                cabSet.add(cab);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cabSet;
    }
}
