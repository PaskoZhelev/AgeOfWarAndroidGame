package com.pmz.ageofwar.domain.area;

import java.util.ArrayList;
import java.util.List;

public class BoardArea {

    private List<Integer> availableCardsIds;

    public BoardArea() {
        availableCardsIds = new ArrayList<>();
        addInitialCardIds();
    }

    private void addInitialCardIds() {
        availableCardsIds.add(0, null);
        for (int i = 1; i < 15; i++) {
            availableCardsIds.add(i);
        }
    }

    public List<Integer> getAvailableCardsIds() {
        return availableCardsIds;
    }
}
