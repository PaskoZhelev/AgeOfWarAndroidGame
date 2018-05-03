package com.pmz.ageofwar.domain.cards;

import com.pmz.ageofwar.enums.CardClan;
import com.pmz.ageofwar.enums.DieType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Card {
    private int id;
    private CardClan clan;
    private int points;
    private Map<List<DieType>, Boolean> requirements;

    public Card(int id, CardClan clan, int points) {
        this.id = id;
        this.clan = clan;
        this.points = points;
        requirements = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CardClan getClan() {
        return clan;
    }

    public void setClan(CardClan clan) {
        this.clan = clan;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Map<List<DieType>, Boolean> getRequirements() {
        return requirements;
    }

    public void setRequirements(Map<List<DieType>, Boolean> requirements) {
        this.requirements = requirements;
    }
}
