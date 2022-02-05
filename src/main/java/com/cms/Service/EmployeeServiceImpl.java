<<<<<<< HEAD
package com.cms.Service;

import com.cms.Dao.EmployeeDao;
import com.cms.Dao.EmployeeDaoImpl;
import com.cms.Model.Employee;

import java.util.logging.Logger;

public class EmployeeServiceImpl extends Employee implements EmployeeService {

    private static final Logger log = Logger.getLogger("EmployeeImpl.class");

    public EmployeeServiceImpl (Integer Id, String Password, String Name, String Email, String Department) {
        super(Id, Password, Name, Email, Department);
    }

    @Override
    public void operations () throws Exception {
        log.info("Employee Service Operations Method Called....");
        EmployeeDao empDao = new EmployeeDaoImpl();
        empDao.operations();
    }
}
=======
package com.cms.Service;

import com.cms.Dao.EmployeeDao;
import com.cms.Dao.EmployeeImplDao;
import com.cms.Model.Employee;

import java.util.logging.Logger;

public class EmployeeServiceImpl extends Employee implements EmployeeService {

    private static final Logger log = Logger.getLogger("EmployeeImpl.class");

    public EmployeeServiceImpl (Integer Id, String Password, String Name, String Email, String Department) {
        super(Id, Password, Name, Email, Department);
    }

    public void operations () throws Exception {
        log.info("Employee Service Operations Method Called....");
        EmployeeDao empDao = new EmployeeImplDao();
        empDao.operations();
    }
}
>>>>>>> 1accd209467e91cd737629e971c55c63bfc95081
