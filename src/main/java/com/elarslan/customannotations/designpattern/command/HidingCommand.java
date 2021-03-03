package com.elarslan.customannotations.designpattern.command;

import com.elarslan.customannotations.exception.InvalidDataException;

@FunctionalInterface
public interface HidingCommand {
    String execute(String field) throws InvalidDataException;
}
