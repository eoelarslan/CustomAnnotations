package com.elarslan.customannotations.client.detail;

import com.elarslan.customannotations.client.dto.Employee;

public interface EmployeeDetail {
    <T extends Employee> T getEmployeeDetail(Integer clientUniqueId, Class<T> type);

    Integer getEmployeeLevel(Integer employeeUniqueId);
}
