package com.elarslan.customannotations.designpattern.strategy;

public interface StrategyPattern<T> {
    void addCommand(final String commandName, final T command);
}
