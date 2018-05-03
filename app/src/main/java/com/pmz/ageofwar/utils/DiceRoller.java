package com.pmz.ageofwar.utils;

import com.pmz.ageofwar.domain.dice.Die;
import com.pmz.ageofwar.enums.DieType;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.pmz.ageofwar.constants.AWConstants.INITIAL_DICE_TO_ROLL;

public class DiceRoller {
    private Random rand;
    private final Die dieOne;
    private final Die dieTwo;
    private final Die dieThree;
    private final Die dieFour;
    private final Die dieFive;
    private final Die dieSix;
    private final Die dieSeven;
    private List<Die> allDice;
    private int diceToRoll;

    public DiceRoller() {
        resetDiceToRoll();
        rand = new Random();
        dieOne = new Die();
        dieTwo = new Die();
        dieThree = new Die();
        dieFour = new Die();
        dieFive = new Die();
        dieSix = new Die();
        dieSeven = new Die();
        allDice = new ArrayList<>();
        allDice.add(0, null);
        allDice.add(1, dieOne);
        allDice.add(2, dieTwo);
        allDice.add(3, dieThree);
        allDice.add(4, dieFour);
        allDice.add(5, dieFive);
        allDice.add(6, dieSix);
        allDice.add(7, dieSeven);
    }

    public void rollRemainingDice() {
        for (int i = 1; i < diceToRoll + 1; i++) {
            rollDie(allDice.get(i));
        }
    }

    private void rollDie(Die die) {
        die.setType(convertNumberToEnum(
                generateRandomNumber()
        ));
    }

    private int generateRandomNumber() {
        return rand.nextInt(6);
    }

    private DieType convertNumberToEnum(int num) {
        return ImageUtils.getDiceEnumNameByNumber(num);
    }

    public void decreaseDiceToRoll(int num) {
        diceToRoll -= num;
    }

    public void resetDiceToRoll() {
        diceToRoll = INITIAL_DICE_TO_ROLL;
    }

    public List<Die> getAllDice() {
        return allDice;
    }

    public int getDiceToRoll() {
        return diceToRoll;
    }
}
