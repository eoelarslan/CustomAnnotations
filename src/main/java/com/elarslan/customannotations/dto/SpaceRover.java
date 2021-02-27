package com.elarslan.customannotations.dto;

import com.elarslan.customannotations.enums.HidingLevel;
import com.elarslan.customannotations.hiding.annotations.HideLevelOne;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SpaceRover {

    @HideLevelOne(hide = HidingLevel.LEVEL_ONE)
    private String name;

    @HideLevelOne(hide = HidingLevel.LEVEL_TWO)
    private String alias;

    @HideLevelOne(hide = HidingLevel.LEVEL_ONE)
    private String type;

    @HideLevelOne(hide = HidingLevel.LEVEL_THREE)
    private String manufacturer;

    @HideLevelOne(hide = HidingLevel.LEVEL_FOUR)
    private String power;//Unit is Watt
}
