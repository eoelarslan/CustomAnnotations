package com.elarslan.customannotations.client.privilege.service;

import com.elarslan.customannotations.client.constant.EmployeeConstant;
import com.elarslan.customannotations.client.detail.EmployeeDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.asm.Opcodes.RETURN;

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

    /**
     *
     * @param hidingLevelValue
     * @param employeeLevel
     * @return
     */
    public boolean isLevelAccessible(Integer hidingLevelValue, Integer employeeLevel){
        return hidingLevelValue - employeeLevel <= EmployeeConstant.ACCESSIBLE_LEVEL_DIFFERENCE;
    }
}
