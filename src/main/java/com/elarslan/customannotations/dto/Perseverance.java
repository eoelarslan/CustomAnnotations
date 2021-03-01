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
public class Perseverance extends SpaceRover {
    @HideLevel(hide = HidingLevel.LEVEL_FOUR)
    @HideFromBelow(hideData = HidingData.EXCEPTIONAL)
    private String secretMessage;
}
