package com.pmz.ageofwar.utils;

import com.pmz.ageofwar.domain.cards.Card;
import com.pmz.ageofwar.enums.CardClan;
import com.pmz.ageofwar.enums.DieType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.pmz.ageofwar.enums.CardClan.CHOSOKABE;
import static com.pmz.ageofwar.enums.CardClan.MORI;
import static com.pmz.ageofwar.enums.CardClan.ODA;
import static com.pmz.ageofwar.enums.CardClan.SHIMAZU;
import static com.pmz.ageofwar.enums.CardClan.TOKUGAWA;
import static com.pmz.ageofwar.enums.CardClan.UESUGI;
import static com.pmz.ageofwar.enums.DieType.BOW;
import static com.pmz.ageofwar.enums.DieType.DAIMYO;
import static com.pmz.ageofwar.enums.DieType.HORSE;
import static com.pmz.ageofwar.enums.DieType.SWORD_1;
import static com.pmz.ageofwar.enums.DieType.SWORD_2;
import static com.pmz.ageofwar.enums.DieType.SWORD_3;

public class CardHandler {

    private Map<Integer, Card> allCards;

    public CardHandler() {
        this.allCards = new HashMap<>();
        setupCards();
    }

    public Map<Integer, Card> getAllCards() {
        return allCards;
    }

    public Card getCard(int number) {
        return allCards.get(number);
    }

    private void setupCards() {
        List<DieType> list = new ArrayList<>();
        Map<List<DieType>, Boolean> map = new HashMap<>();

        int id = 1;
        Card card = new Card(id, SHIMAZU, 3);
        addRequirementList(map, DAIMYO, DAIMYO);
        addRequirementList(map, BOW);
        addRequirementList(map, HORSE);
        addRequirementList(map, SWORD_2, SWORD_2);
        card.setRequirements(map);
        allCards.put(1, card);

        map = new HashMap<>();
        id = 2;
        card = new Card(id, UESUGI, 3);
        addRequirementList(map, DAIMYO);
        addRequirementList(map, BOW, HORSE);
        addRequirementList(map, SWORD_3, SWORD_3);
        card.setRequirements(map);
        allCards.put(id, card);

        map = new HashMap<>();
        id = 3;
        card = new Card(id, UESUGI, 4);
        addRequirementList(map, BOW, BOW);
        addRequirementList(map, HORSE, HORSE);
        card.setRequirements(map);
        allCards.put(id, card);

        map = new HashMap<>();
        id = 4;
        card = new Card(id, MORI, 2);
        addRequirementList(map, DAIMYO);
        addRequirementList(map, SWORD_3, SWORD_3, SWORD_2);
        card.setRequirements(map);
        allCards.put(id, card);

        map = new HashMap<>();
        id = 5;
        card = new Card(id, MORI, 2);
        addRequirementList(map, HORSE, HORSE);
        addRequirementList(map, SWORD_3, SWORD_2);
        addRequirementList(map, SWORD_2);
        card.setRequirements(map);
        allCards.put(id, card);

        map = new HashMap<>();
        id = 6;
        card = new Card(id, TOKUGAWA, 1);
        addRequirementList(map, BOW, BOW);
        addRequirementList(map, DAIMYO);
        card.setRequirements(map);
        allCards.put(id, card);

        map = new HashMap<>();
        id = 7;
        card = new Card(id, TOKUGAWA, 2);
        addRequirementList(map, BOW);
        addRequirementList(map, HORSE);
        addRequirementList(map, DAIMYO);
        addRequirementList(map, SWORD_3);
        card.setRequirements(map);
        allCards.put(id, card);

        map = new HashMap<>();
        id = 8;
        card = new Card(id, TOKUGAWA, 3);
        addRequirementList(map, BOW, HORSE);
        addRequirementList(map, BOW, HORSE);
        addRequirementList(map, SWORD_3);
        card.setRequirements(map);
        allCards.put(id, card);

        map = new HashMap<>();
        id = 9;
        card = new Card(id, ODA, 1);
        addRequirementList(map, BOW);
        addRequirementList(map, HORSE);
        addRequirementList(map, DAIMYO);
        card.setRequirements(map);
        allCards.put(id, card);

        map = new HashMap<>();
        id = 10;
        card = new Card(id, ODA, 1);
        addRequirementList(map, BOW);
        addRequirementList(map, BOW);
        addRequirementList(map, SWORD_3, SWORD_3, SWORD_1);
        card.setRequirements(map);
        allCards.put(id, card);

        map = new HashMap<>();
        id = 11;
        card = new Card(id, ODA, 2);
        addRequirementList(map, BOW);
        addRequirementList(map, HORSE, HORSE);
        addRequirementList(map, SWORD_3, SWORD_2);
        card.setRequirements(map);
        allCards.put(id, card);

        map = new HashMap<>();
        id = 12;
        card = new Card(id, ODA, 3);
        addRequirementList(map, SWORD_3, SWORD_3, SWORD_3, SWORD_1);
        card.setRequirements(map);
        allCards.put(id, card);

        map = new HashMap<>();
        id = 13;
        card = new Card(id, CHOSOKABE, 1);
        addRequirementList(map, DAIMYO, DAIMYO);
        addRequirementList(map, HORSE);
        card.setRequirements(map);
        allCards.put(id, card);

        map = new HashMap<>();
        id = 14;
        card = new Card(id, CHOSOKABE, 2);
        addRequirementList(map, DAIMYO);
        addRequirementList(map, SWORD_3, SWORD_1);
        addRequirementList(map, SWORD_3, SWORD_1);
        card.setRequirements(map);
        allCards.put(id, card);

    }

    private void addRequirementList(Map<List<DieType>, Boolean> map, DieType... dieTypes){
        List<DieType> list = new ArrayList<>();
        list.addAll(Arrays.asList(dieTypes));
        map.put(list, false);
    }
}
