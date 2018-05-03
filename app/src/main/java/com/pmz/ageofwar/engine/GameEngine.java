package com.pmz.ageofwar.engine;

import com.pmz.ageofwar.domain.area.BoardArea;
import com.pmz.ageofwar.domain.cards.Card;
import com.pmz.ageofwar.domain.dice.Die;
import com.pmz.ageofwar.enums.DieType;
import com.pmz.ageofwar.utils.CardHandler;
import com.pmz.ageofwar.utils.DiceRoller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.pmz.ageofwar.constants.AWConstants.INITIAL_DICE_TO_ROLL;

public class GameEngine {

    private DiceRoller diceRoller;
    private BoardArea boardArea;
    private CardHandler cardHandler;

    public GameEngine() {
        diceRoller = new DiceRoller();
        boardArea = new BoardArea();
        cardHandler = new CardHandler();
    }

    public void rollAvailableDice() {
        diceRoller.rollRemainingDice();
    }

    public void decreaseDiceToRoll(int num) {
        diceRoller.decreaseDiceToRoll(num);
    }

    public void resetDiceToRoll() {
        diceRoller.resetDiceToRoll();
    }

    public int getDiceToRoll() {
        return diceRoller.getDiceToRoll();
    }

    public List<Die> getAllDice() {
        return diceRoller.getAllDice();
    }

    public List<Die> getAllSelectedDice() {
        List<Die> selectedDice = new ArrayList<>();
        for (Die die : diceRoller.getAllDice()) {
            if(die != null && die.isSelected()) {
                selectedDice.add(die);
            }
        }
        return selectedDice;
    }

    public List<DieType> getSelectedDieTypeList() {
        List<Die> selectedDice = getAllSelectedDice();
        List<DieType> dieTypes = new ArrayList<>();
        for (Die die : selectedDice) {
            if(die != null) {
                dieTypes.add(die.getType());
            }
        }

        return dieTypes;
    }

    public Die getDie(int num) {
        return diceRoller.getAllDice().get(num);
    }

    public void selectDie(int num){
        getDie(num).select();
    }

    public void unselectDie(int num){
        getDie(num).unselect();
    }

    public void unselectAllDice() {
        for (Die die : getAllDice()) {
            if(die != null) {
                die.unselect();
            }
        }
    }

    public List<Integer> getBoardAreaCards() {
        return boardArea.getAvailableCardsIds();
    }

    public Map<Integer, Card> getAllCards() {
        return cardHandler.getAllCards();
    }

    public Card getCard(int number) {
        return cardHandler.getCard(number);
    }
}
