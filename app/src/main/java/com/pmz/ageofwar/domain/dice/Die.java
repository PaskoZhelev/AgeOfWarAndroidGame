package com.pmz.ageofwar.domain.dice;

import com.pmz.ageofwar.enums.DieType;

public class Die {

    private DieType type;
    private boolean selected;

    public DieType getType() {
        return type;
    }

    public void setType(DieType type) {
        this.type = type;
    }

    public void select() {
        selected = true;
    }

    public void unselect() {
        selected = false;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
