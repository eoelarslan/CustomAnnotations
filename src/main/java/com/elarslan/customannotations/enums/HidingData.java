package com.elarslan.customannotations.enums;

/**
 * This enum class advices how to mask a data.
 *
 * BARE: Non-masked
 * SIMPLE: Suitable for maskForSimpleData (@Link HidingStrategyService)
 * SPECIFIC: Suitable for maskForSpecificData (@Link HidingStrategyService)
 * EXCEPTIONAL: Suitable for maskForExceptionalData (@Link HidingStrategyService)
 */
public enum HidingData {
    BARE, SIMPLE, SPECIFIC, EXCEPTIONAL
}
