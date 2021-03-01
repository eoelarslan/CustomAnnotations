package com.elarslan.customannotations.designpattern.strategy;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HidingStrategyService {
    /**
     * After first character, mask each vowel of the data
     * @param data (@link String)
     * @return masked data
     */
    public String maskForSimpleData(String data) {
        return "";
    }

    /**
     * Mask last four characters
     * @param data (@link String)
     * @return masked data
     */
    public String maskForSpecificData(String data){
        return "";
    }

    /**
     * Mask all characters
     * @param data (@link String)
     * @return masked data
     */
    public String maskForExceptionalData(String data){
        return "";
    }
}
