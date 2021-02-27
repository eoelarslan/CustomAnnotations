package com.elarslan.customannotations.hiding.annotations;

import com.elarslan.customannotations.enums.HidingLevel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface HideLevelOne {
    HidingLevel hide();
}
