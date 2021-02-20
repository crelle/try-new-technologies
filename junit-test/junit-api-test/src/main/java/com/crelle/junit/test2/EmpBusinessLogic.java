package com.crelle.junit.test2;

/**
 * @author:crelle
 * @className:EmpBusinessLogic
 * @version:1.0.0
 * @date:2021/2/20
 * @description:XX
 **/
public class EmpBusinessLogic {

    //雇员每年的薪水
    public double calculateYearlySalary(EmployeeDetails employeeDetails) {
        double yearlySalary = 0;
        yearlySalary = employeeDetails.getMonthlySalary() * 12;
        return yearlySalary;
    }

    //雇员的评估金额
    public double calculateAppraisal(EmployeeDetails employeeDetails) {
        double appraisal = 0;
        if (employeeDetails.getMonthlySalary() < 10000) {
            appraisal = 500;
        } else {
            appraisal = 1000;
        }
        return appraisal;
    }

}
