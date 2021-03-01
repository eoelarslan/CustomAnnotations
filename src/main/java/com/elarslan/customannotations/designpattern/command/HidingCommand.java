package com.elarslan.customannotations.designpattern.command;

@FunctionalInterface
public interface HidingCommand {
    String execute(String field);
}
