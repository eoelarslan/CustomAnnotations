package com.elarslan.customannotations.dto;

import com.elarslan.customannotations.enums.HidingData;
import com.elarslan.customannotations.enums.HidingLevel;
import com.elarslan.customannotations.hiding.annotations.HideFromBelow;
import com.elarslan.customannotations.hiding.annotations.HideLevel;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SpaceRover {

    @HideLevel(hide = HidingLevel.LEVEL_ONE)
    @HideFromBelow(hideData = HidingData.BARE)
    private String name;

    @HideLevel(hide = HidingLevel.LEVEL_TWO)
    @HideFromBelow(hideData = HidingData.SIMPLE)
    private String alias;

    @HideLevel(hide = HidingLevel.LEVEL_ONE)
    @HideFromBelow(hideData = HidingData.BARE)
    private String type;

    @HideLevel(hide = HidingLevel.LEVEL_THREE)
    @HideFromBelow(hideData = HidingData.SPECIFIC)
    private String manufacturer;

    @HideLevel(hide = HidingLevel.LEVEL_FOUR)
    @HideFromBelow(hideData = HidingData.SPECIFIC)
    private String power;//Unit is Watt
}
