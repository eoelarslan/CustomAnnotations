package com.elarslan.customannotations.client.constant;

import com.google.common.collect.ImmutableMap;

public final class EmployeeConstant {

    private EmployeeConstant() {
    }

    public static final String LEVEL_1 = "LEVEL1";
    public static final String LEVEL_2 = "LEVEL2";
    public static final String LEVEL_3 = "LEVEL3";
    public static final String LEVEL_4 = "LEVEL4";
    public static final String secretMessage = "Dare mighty things";

    public static final int ACCESSIBLE_LEVEL_DIFFERENCE = 1;

    /*ImmutableMap<Integer, String> immutableMap
            = ImmutableMap.of(1, "LEVEL1", 2, "LEVEL2");*/

    /**
     * Key: Employee Id
     * Value: Employee Level
     */
    public static final ImmutableMap<Integer, Integer> employeeLevels = ImmutableMap.<Integer, Integer>builder()
            .put(1, 1)
            .put(2, 2)
            .put(3, 3)
            .put(4, 4)
            .build();

}
