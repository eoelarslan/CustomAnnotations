package com.elarslan.customannotations.designpattern.strategy;

import com.elarslan.customannotations.client.detail.EmployeeDetailService;
import com.elarslan.customannotations.client.dto.TechnicalEmployee;
import com.elarslan.customannotations.client.privilege.service.PrivilegeService;
import com.elarslan.customannotations.designpattern.command.HidingCommand;
import com.elarslan.customannotations.enums.HidingData;
import com.elarslan.customannotations.enums.HidingLevel;
import com.elarslan.customannotations.exception.InvalidDataException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Component
@Transactional
public class HidingStrategy implements StrategyPattern<HidingCommand> {
    private final Map<String, HidingCommand> hidingCommandMap = new HashMap<>();


    private final HidingStrategyService hidingStrategyService;
    private final PrivilegeService privilegeService;
    private final EmployeeDetailService employeeDetailService;

    public HidingStrategy(HidingStrategyService hidingStrategyService, PrivilegeService privilegeService, EmployeeDetailService employeeDetailService) {
        this.hidingStrategyService = hidingStrategyService;
        this.privilegeService = privilegeService;
        this.employeeDetailService = employeeDetailService;
    }

    @PostConstruct
    public void init() {
        addCommand(HidingData.BARE.name(), hidingStrategyService::maskForExceptionalData);
        addCommand(HidingData.SIMPLE.name(), hidingStrategyService::maskForExceptionalData);
        addCommand(HidingData.SPECIFIC.name(), hidingStrategyService::maskForSpecificData);
        addCommand(HidingData.EXCEPTIONAL.name(), hidingStrategyService::maskForSimpleData);
    }

    @Override
    public void addCommand(String commandName, HidingCommand command) {
        hidingCommandMap.put(commandName, command);
    }

    public String executeCommand(HidingLevel hidingLevel, HidingData hidingData, String data) throws InvalidDataException {
        String hidingLevelName = hidingLevel.name();
        String hidingDataName = hidingData.name();
        if (data.isBlank()) {
            //TODO Needs work for logging and proper return data. (OnurE)
            return ""; // nothing to mask!!!
        }
        Integer hidingLevelValue = hidingLevel.level();
        TechnicalEmployee technicalEmployee = employeeDetailService.getEmployeeDetail(1, TechnicalEmployee.class);

        return maskData(data, hidingDataName, hidingLevelValue, technicalEmployee);
    }

    private String maskData(String data, String hidingDataName, Integer hidingLevelValue, TechnicalEmployee technicalEmployee) throws InvalidDataException {
        if (privilegeService.isDataVisible(hidingLevelValue, technicalEmployee.getLevel())) {
            return data;
        }
        //If employee has lower level, than logic must be executed to mask data.
        if (privilegeService.isLevelAccessible(hidingLevelValue, technicalEmployee.getLevel())) {
            return hidingCommandMap.get(hidingDataName).execute(data);
        } else {
            return hidingStrategyService.maskForExceptionalData(data);
        }
    }
}
