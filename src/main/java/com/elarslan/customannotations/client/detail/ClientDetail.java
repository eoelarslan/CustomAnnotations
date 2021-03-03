package com.elarslan.customannotations.client.detail;

import com.elarslan.customannotations.client.dto.Employee;

public interface ClientDetail {
    <T extends Employee> T getClientDetail(Integer clientUniqueId, Class<T> type);

    Integer getClientLevel(Integer clientUniqueId);
}
