package com.elarslan.customannotations.client.detail;

import com.elarslan.customannotations.client.constant.EmployeeConstant;
import com.elarslan.customannotations.client.dto.Employee;
import com.elarslan.customannotations.client.dto.TechnicalEmployee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Slf4j
@Service
@Transactional
public class EmployeeDetailService implements EmployeeDetail {

    @Override
    public <T extends Employee> T getEmployeeDetail(Integer clientUniqueId, Class<T> type) {
        //TODO Proper service will be implemented (OnurE)
        //Dummy Data
        TechnicalEmployee technicalEmployee = new TechnicalEmployee("Adam Steltzner", 1963, EmployeeConstant.employeeLevels.get(clientUniqueId), Arrays.asList("IntelliJ", "Python", "Terraform"));
        return type.cast(technicalEmployee);
    }

    @Override
    public Integer getEmployeeLevel(Integer employeeUniqueId) {
        //TODO Proper service will be implemented (OnurE)
        //Returns dummy data
        return EmployeeConstant.employeeLevels.get(employeeUniqueId);
    }
}
