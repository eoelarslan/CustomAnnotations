package com.elarslan.customannotations.designpattern.strategy;

import com.elarslan.customannotations.exception.InvalidDataException;
import com.elarslan.customannotations.masking.MaskingInput;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HidingStrategyService {

    private static final int FOUR_DIGITS = 4;

    /**
     * After first character, mask each vowel of the data
     *
     * @param data (@link String)
     * @return masked data
     */
    public String maskForSimpleData(String data) {
        return MaskingInput.maskVowelsAfterFirstChar(data);
    }

    /**
     * Mask last four characters
     *
     * @param data (@link String)
     * @return masked data
     */
    public String maskForSpecificData(String data) throws InvalidDataException {
        if (data.length() <= FOUR_DIGITS) {
            return MaskingInput.maskAll();
        }
        return MaskingInput.maskString(data, data.length() - FOUR_DIGITS, data.length());
    }

    /**
     * Mask all characters
     *
     * @return masked data (@link String). Length of masked data will be always ten.
     */
    public String maskForExceptionalData(String data) {
        return MaskingInput.maskAll();
    }
}
