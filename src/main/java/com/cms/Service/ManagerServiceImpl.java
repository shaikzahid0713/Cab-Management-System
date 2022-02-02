package com.cms.Service;

import com.cms.Dao.ManagerDao;
import com.cms.Dao.ManagerDaoImpl;
import com.cms.Model.Employee;

import java.util.logging.Logger;

public class ManagerServiceImpl extends Employee implements ManagerService {

    private static final Logger log = Logger.getLogger("ManagerServiceImpl.class");

    Employee manager = new Employee();


    public ManagerServiceImpl (Integer employeeId, String empPassword, String employeeName, String employeeEmail, String employeeDepartment) {
        super(employeeId, empPassword, employeeName, employeeEmail, employeeDepartment);
        manager.setManager(true);
    }

    @Override
    public void decide () throws Exception {
        log.info("Manager Service Implementation Class Called....");
        ManagerDao managerDao = new ManagerDaoImpl();
        managerDao.decide();
    }
}
