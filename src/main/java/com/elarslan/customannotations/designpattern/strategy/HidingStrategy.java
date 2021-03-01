package com.elarslan.customannotations.designpattern.strategy;

import com.elarslan.customannotations.designpattern.command.HidingCommand;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Component
@Transactional
public class HidingStrategy {
    private final Map<String, HidingCommand> hidingCommandMap = new HashMap<>();
}
