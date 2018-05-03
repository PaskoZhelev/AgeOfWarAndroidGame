package com.pmz.ageofwar.utils;

import com.pmz.ageofwar.enums.DieType;

public class DiceUtils {

    public static boolean isSwordDie(DieType dieType) {
        switch (dieType) {
            case SWORD_1:
            case SWORD_2:
            case SWORD_3:
                return true;

                default:
                    return false;
        }
    }
}
