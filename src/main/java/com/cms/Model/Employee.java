<<<<<<< HEAD
/* Employee Requirements :-
   1. Attributes :
            Id, Name, Email, Department
   2. Methods :
            Raise a cab request.
            if rejected, can request again.
*/

package com.cms.Model;


public class Employee {
    private Integer employeeId;
    private String empPassword;
    private String employeeName;
    private String employeeEmail;
    private String employeeDepartment;
    private Boolean isManager;

    public Employee (Integer employeeId, String empPassword, String employeeName, String employeeEmail, String employeeDepartment) {
        this.employeeId = employeeId;
        this.empPassword = empPassword;
        this.employeeName = employeeName;
        this.employeeEmail = employeeEmail;
        this.employeeDepartment = employeeDepartment;
        this.isManager = false;
    }

    public Employee () {

    }

    public String getEmpPassword () {
        return empPassword;
    }

    public void setEmpPassword (String empPassword) {
        this.empPassword = empPassword;
    }

    public Integer getEmployeeId () {
        return employeeId;
    }

    public void setEmployeeId (Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName () {
        return employeeName;
    }

    public void setEmployeeName (String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeEmail () {
        return employeeEmail;
    }

    public void setEmployeeEmail (String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeDepartment () {
        return employeeDepartment;
    }

    public void setEmployeeDepartment (String employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }

    public boolean isManager () {
        return isManager;
    }

    public void setManager (boolean isManager) {
        this.isManager = isManager;
    }

    @Override
    public String toString () {
        return "employeeModel{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", employeeEmail='" + employeeEmail + '\'' +
                ", employeeDepartment='" + employeeDepartment + '\'' +
                ", isManager=" + isManager +
                '}';
    }

}
=======
/* Employee Requirements :-
   1. Attributes :
            Id, Name, Email, Department
   2. Methods :
            Raise a cab request.
            if rejected, can request again.
*/

package com.cms.Model;


public class Employee {
    private Integer employeeId;
    private String empPassword;
    private String employeeName;
    private String employeeEmail;
    private String employeeDepartment;
    private Boolean isManager;

    public Employee (Integer employeeId, String empPassword, String employeeName, String employeeEmail, String employeeDepartment) {
        this.employeeId = employeeId;
        this.empPassword = empPassword;
        this.employeeName = employeeName;
        this.employeeEmail = employeeEmail;
        this.employeeDepartment = employeeDepartment;
        this.isManager = false;
    }

    public Employee () {

    }

    public String getEmpPassword () {
        return empPassword;
    }

    public void setEmpPassword (String empPassword) {
        this.empPassword = empPassword;
    }

    public Integer getEmployeeId () {
        return employeeId;
    }

    public void setEmployeeId (Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName () {
        return employeeName;
    }

    public void setEmployeeName (String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeEmail () {
        return employeeEmail;
    }

    public void setEmployeeEmail (String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeDepartment () {
        return employeeDepartment;
    }

    public void setEmployeeDepartment (String employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }

    public boolean isManager () {
        return isManager;
    }

    public void setManager (boolean isManager) {
        this.isManager = isManager;
    }

    @Override
    public String toString () {
        return "employeeModel{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", employeeEmail='" + employeeEmail + '\'' +
                ", employeeDepartment='" + employeeDepartment + '\'' +
                ", isManager=" + isManager +
                '}';
    }

}
>>>>>>> 1accd209467e91cd737629e971c55c63bfc95081
