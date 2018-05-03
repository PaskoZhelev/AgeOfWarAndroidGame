package com.pmz.ageofwar.utils;

import com.pmz.ageofwar.constants.AWConstants;
import com.pmz.ageofwar.enums.DieType;

import static com.pmz.ageofwar.constants.AWConstants.DICE_TO_ENUM_LIST;
import static com.pmz.ageofwar.constants.AWConstants.ENUM_TO_IMAGE_NAME_MAP;

public class ImageUtils {

    public static DieType getDiceEnumNameByNumber(int number) {
        return DICE_TO_ENUM_LIST.get(number);
    }

    public static String getDiceNameByType(DieType type) {
        return ENUM_TO_IMAGE_NAME_MAP.get(type);
    }
}
