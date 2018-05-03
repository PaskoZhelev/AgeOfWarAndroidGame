package com.pmz.ageofwar.constants;

import com.pmz.ageofwar.enums.DieType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AWConstants {
    public static final String DIE_PREFIX = "die";
    public static final String TILE_PREFIX = "tile";

    public static final int ROLL_ANIMATION_DURATION = 280;
    public static final int INITIAL_DICE_TO_ROLL = 7;
    public static final List<DieType> DICE_TO_ENUM_LIST;
    public static final Map<DieType, String> ENUM_TO_IMAGE_NAME_MAP;

    static {
        DICE_TO_ENUM_LIST = new ArrayList<>();
        ENUM_TO_IMAGE_NAME_MAP = new HashMap<>();

        DICE_TO_ENUM_LIST.add(0, DieType.SWORD_1);
        DICE_TO_ENUM_LIST.add(1, DieType.SWORD_2);
        DICE_TO_ENUM_LIST.add(2, DieType.SWORD_3);
        DICE_TO_ENUM_LIST.add(3, DieType.BOW);
        DICE_TO_ENUM_LIST.add(4, DieType.HORSE);
        DICE_TO_ENUM_LIST.add(5, DieType.DAIMYO);

        ENUM_TO_IMAGE_NAME_MAP.put(DieType.SWORD_1, DIE_PREFIX + "1sword");
        ENUM_TO_IMAGE_NAME_MAP.put(DieType.SWORD_2, DIE_PREFIX + "2sword");
        ENUM_TO_IMAGE_NAME_MAP.put(DieType.SWORD_3, DIE_PREFIX + "3sword");
        ENUM_TO_IMAGE_NAME_MAP.put(DieType.BOW, DIE_PREFIX + "bow");
        ENUM_TO_IMAGE_NAME_MAP.put(DieType.HORSE, DIE_PREFIX + "horse");
        ENUM_TO_IMAGE_NAME_MAP.put(DieType.DAIMYO, DIE_PREFIX + "daimyo");
    }
}
