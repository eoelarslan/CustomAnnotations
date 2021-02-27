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
public class Perseverance extends SpaceRover{
    @HideLevelOne(hide = HidingLevel.LEVEL_FOUR)
    private String secretMessage;
}
