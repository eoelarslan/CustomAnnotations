package com.elarslan.customannotations.client.detail;

import com.elarslan.customannotations.client.dto.Employee;
import com.elarslan.customannotations.client.dto.TechnicalEmployee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Service
@Transactional
public class ClientDetailService implements ClientDetail {

    @Override
    public <T extends Employee> T getClientDetail(Integer clientUniqueId, Class<T> type) {
        //TODO Proper service will be implemented (OnurE)
        //Dummy Data
        TechnicalEmployee technicalEmployee = new TechnicalEmployee("Adam Steltzner", 1963, Arrays.asList("IntelliJ", "Python", "Terraform"));
        return type.cast(technicalEmployee);
    }

    @Override
    public Integer getClientLevel(Integer clientUniqueId) {
        //TODO Proper service will be implemented (OnurE)
        //Returned dummy data
        return 1;
    }
}
