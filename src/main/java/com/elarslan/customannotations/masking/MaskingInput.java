package com.elarslan.customannotations.masking;

import com.elarslan.customannotations.exception.InvalidDataException;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotNull;
import java.util.StringJoiner;

public final class MaskingInput {

    private static final String VOWELS = "AEIOUaeiou";
    private static final String REGEX_FOR_VOWELS = "[AaEeIiOoUu]";
    private static final String FULL_MASKING = "**********";

    private MaskingInput() {
    }

    public static String maskString(String data, int start, int end)
            throws InvalidDataException {

        if (data.isBlank()) {
            return StringUtils.EMPTY;
        }
        if (start < 0) {
            start = 0;
        }
        if (end > data.length()) {
            end = data.length();
        }
        if (start > end) {
            throw new InvalidDataException("MaskingInput : maskString - startIndex cannot be greater than endIndex");
        }
        int maskLength = end - start;
        if (maskLength == 0) {
            return data;
        }
        StringJoiner stringjoiner = new StringJoiner("");
        for (int i = 0; i < maskLength; i++) {
            stringjoiner.add("*");
        }
        return data.substring(0, start)
                + stringjoiner.toString()
                + data.substring(start + maskLength);
    }

    private static boolean isVowel(char c) {
        return VOWELS.indexOf(c) != -1;
    }

    public static String maskVowels(@NotNull String data) {
        data = data.replaceAll(REGEX_FOR_VOWELS, "*");
        return data;
    }

    public static String maskVowelsAfterFirstChar(@NotNull String data) {
        return data.charAt(0) + maskVowels(data.substring(1,data.length()));
    }

    public static String maskAll() {
        return FULL_MASKING;
    }

}
