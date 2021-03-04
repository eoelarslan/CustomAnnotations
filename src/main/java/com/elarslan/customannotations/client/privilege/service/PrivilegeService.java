package com.elarslan.customannotations.client.privilege.service;

import com.elarslan.customannotations.client.detail.EmployeeDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
public class PrivilegeService {

    @Autowired
    private EmployeeDetailService employeeDetailService;

    public String populateDataWithLevel(){

        return "";
    }

    /**
     *
     * @param hidingLevelValue
     * @param employeeLevel
     * @return
     */
    public boolean isDataVisible(Integer hidingLevelValue, Integer employeeLevel){
        return employeeLevel.compareTo(hidingLevelValue) > 0;
    }
}
