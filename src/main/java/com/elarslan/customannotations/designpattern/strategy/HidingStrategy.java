package com.elarslan.customannotations.designpattern.strategy;

import com.elarslan.customannotations.designpattern.command.HidingCommand;
import com.elarslan.customannotations.enums.HidingData;
import com.elarslan.customannotations.enums.HidingLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
@Transactional
public class HidingStrategy implements StrategyPattern<HidingCommand> {
    private final Map<String, HidingCommand> hidingCommandMap = new HashMap<>();

    @Autowired
    private HidingStrategyService hidingStrategyService;

    @PostConstruct
    public void init() {
        addCommand(HidingLevel.LEVEL_ONE.name(), hidingStrategyService::maskForExceptionalData);
        addCommand(HidingLevel.LEVEL_TWO.name(), hidingStrategyService::maskForExceptionalData);
        addCommand(HidingLevel.LEVEL_THREE.name(), hidingStrategyService::maskForSpecificData);
        addCommand(HidingLevel.LEVEL_FOUR.name(), hidingStrategyService::maskForSimpleData);
    }

    @Override
    public void addCommand(String commandName, HidingCommand command) {
        hidingCommandMap.put(commandName, command);
    }

    public String executeCommand(HidingLevel hidingLevel, HidingData hidingData, String data) {
        String hidingLevelName = hidingLevel.name();
        String hidingDataName = hidingData.name();
        if(data.isBlank()) {
            //TODO Needs work for logging and proper return data. (OnurE)
            return ""; // nothing to mask!!!
        }
        return "";
    }
}
