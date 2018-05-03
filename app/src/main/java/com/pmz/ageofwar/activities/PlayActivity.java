package com.pmz.ageofwar.activities;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.pmz.ageofwar.R;
import com.pmz.ageofwar.domain.cards.Card;
import com.pmz.ageofwar.engine.GameEngine;
import com.pmz.ageofwar.enums.DieType;
import com.pmz.ageofwar.utils.ImageUtils;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.pmz.ageofwar.constants.AWConstants.ROLL_ANIMATION_DURATION;
import static com.pmz.ageofwar.constants.AWConstants.TILE_PREFIX;

@EActivity
public class PlayActivity extends AppCompatActivity {


    private GameEngine gameEngine;

    @ViewById
    ImageView die1;
    @ViewById
    ImageView die2;
    @ViewById
    ImageView die3;
    @ViewById
    ImageView die4;
    @ViewById
    ImageView die5;
    @ViewById
    ImageView die6;
    @ViewById
    ImageView die7;

    @ViewById
    ImageView space1;
    @ViewById
    ImageView space2;
    @ViewById
    ImageView space3;
    @ViewById
    ImageView space4;
    @ViewById
    ImageView space5;
    @ViewById
    ImageView space6;
    @ViewById
    ImageView space7;
    @ViewById
    ImageView space8;
    @ViewById
    ImageView space9;
    @ViewById
    ImageView space10;
    @ViewById
    ImageView space11;
    @ViewById
    ImageView space12;
    @ViewById
    ImageView space13;
    @ViewById
    ImageView space14;

    @ViewById
    ImageView selectedCard;

    @ViewById
    ImageView rollBtn;
    @ViewById
    ImageView endTurnBtn;

    @ViewById
    LinearLayout boardAreaCardsLayout;
    @ViewById
    LinearLayout selectedCardLayout;

    List<ImageView> allDiceViews;
    List<ImageView> spaceViews;
    Map<ImageView, Card> spaceCardMap;

     Animation rotationAnimation;

     private int currentPlayer = 1;
     private Card currentSelectedCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        hideNavigationBar();
        setupObjects();
        setupViews();
        setupDiceViews();
        displayAvailableBoardAreaCards();
        hideAllDiceImageViews();
    }

    @Override
    protected void onResume() {
        super.onResume();
        hideNavigationBar();
    }

    private void hideNavigationBar() {
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            this.getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

    private int getDrawableImageIdByName(String resourceName) {
        return getResources().getIdentifier(resourceName, "drawable", getPackageName());
    }

    private void changeImageView(ImageView imageView, String name) {
        imageView.setImageResource(getDrawableImageIdByName(
                name));
    }

    private void applyAnimation(ImageView dieView) {
        dieView.startAnimation(rotationAnimation);
    }

    private void setupObjects() {
        gameEngine = new GameEngine();
        rotationAnimation = AnimationUtils.loadAnimation(
                PlayActivity.this, R.anim.rotateanimation);
    }

    private void setupViews() {
        allDiceViews = new ArrayList<>();
        spaceViews = new ArrayList<>();
        spaceCardMap = new HashMap<>();
        allDiceViews.add(null);
        allDiceViews.add(1, die1);
        allDiceViews.add(2, die2);
        allDiceViews.add(3, die3);
        allDiceViews.add(4, die4);
        allDiceViews.add(5, die5);
        allDiceViews.add(6, die6);
        allDiceViews.add(7, die7);

        spaceViews.add(null);
        spaceViews.add(1, space1);
        spaceViews.add(2, space2);
        spaceViews.add(3, space3);
        spaceViews.add(4, space4);
        spaceViews.add(5, space5);
        spaceViews.add(6, space6);
        spaceViews.add(7, space7);
        spaceViews.add(8, space8);
        spaceViews.add(9, space9);
        spaceViews.add(10, space10);
        spaceViews.add(11, space11);
        spaceViews.add(12, space12);
        spaceViews.add(13, space13);
        spaceViews.add(14, space14);

        for (ImageView view : spaceViews) {
            if(view != null) {
                spaceCardMap.put(view, null);
            }
        }

    }

    private void setupDiceViews() {
        for (int i = 1; i < 8; i++) {
            final int j = i;
            allDiceViews.get(i).setOnClickListener(new View.OnClickListener() {
                public void onClick(View arg0) {
                    clickDie(j);
                }
            });
        }
    }

    private void clickDie(int dieNum) {
        ImageView dieImageView = allDiceViews.get(dieNum);
        if (gameEngine.getDie(dieNum).isSelected()) {
            gameEngine.unselectDie(dieNum);
            dieImageView.setBackgroundResource(0);
        } else {
            gameEngine.selectDie(dieNum);
            dieImageView.setBackgroundResource(R.drawable.buttonbackground);
        }
    }

    private void makeButtonUnclickable(ImageView button){
        button.setEnabled(false);
    }

    private void makeButtonClickable(ImageView button){
        button.setEnabled(true);
    }

    @Click(R.id.rollBtn)
    void rollDiceAfterAnimation() {
        showAvailableDiceImageViews();
        for (int i = 1; i < gameEngine.getDiceToRoll() + 1; i++) {
            ImageView dieView = allDiceViews.get(i);
            applyAnimation(dieView);

        }

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                rollDice();
                //makeButtonUnclickable(rollBtn);
            }
        }, ROLL_ANIMATION_DURATION);
    }

    @Click(R.id.endTurnBtn)
    void clickEndTurnButton() {
        List<DieType> selectedDiceTypes = gameEngine.getSelectedDieTypeList();
        if(selectedDiceTypes.isEmpty()) {
            return;
        }

        Map<List<DieType>, Boolean> requirementMap =
                currentSelectedCard.getRequirements();

        doSelectedDiceMatchRequirements(selectedDiceTypes, requirementMap);

        gameEngine.decreaseDiceToRoll(selectedDiceTypes.size());
        gameEngine.unselectAllDice();
        hideAllDiceImageViews();
    }

    private boolean doSelectedDiceMatchRequirements(List<DieType> selectedDiceTypes, Map<List<DieType>, Boolean> requirementMap) {
        for (Map.Entry<List<DieType>, Boolean> entry : requirementMap.entrySet()) {
            if(selectedDiceTypes.containsAll(entry.getKey())){
                entry.setValue(true);
                return true;
            }
        }

        return false;
    }

    private void rollDice() {
        gameEngine.rollAvailableDice();
        updateDiceImages();
    }

    private void showBoardAreaCardsLayout(){
        boardAreaCardsLayout.setVisibility(View.VISIBLE);
        selectedCardLayout.setVisibility(View.GONE);
    }

    private void showSelectedCardLayout(){
        boardAreaCardsLayout.setVisibility(View.GONE);
        selectedCardLayout.setVisibility(View.VISIBLE);
        if(currentSelectedCard != null) {
            changeImageView(selectedCard,
                    TILE_PREFIX + currentSelectedCard.getId());
        } else {
            selectedCard.setImageResource(0);
        }
    }

    private void displayAvailableBoardAreaCards() {
        hideAllBoardAreaCards();
        List<Integer> boardAreaCards = gameEngine.getBoardAreaCards();
        for (int i = 1; i < boardAreaCards.size(); i++) {
            int cardId = boardAreaCards.get(i);
            setCardOnSpace(i, cardId);
        }
    }

    private void hideAllBoardAreaCards() {
        for (Map.Entry<ImageView, Card> entry : spaceCardMap.entrySet()) {
                entry.getKey().setImageResource(0);
                entry.setValue(null);
        }
    }

    private void setCardOnSpace(int spaceNum, int cardId) {
        ImageView spaceView = spaceViews.get(spaceNum);
        final Card card = gameEngine.getCard(cardId);
        changeImageView(spaceView, TILE_PREFIX + cardId);
        spaceCardMap.put(spaceView, card);
        spaceView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentSelectedCard = card;
                showSelectedCardLayout();
            }
        });
    }

    private void updateDiceImages() {
        for (int i = 1; i < gameEngine.getDiceToRoll() + 1; i++) {
            ImageView dieView = allDiceViews.get(i);
            String dieImageName = ImageUtils
                    .getDiceNameByType(gameEngine.getDie(i).getType());
            changeImageView(dieView, dieImageName);
        }
    }

    private void showAvailableDiceImageViews() {
        for (int i = 1; i < gameEngine.getDiceToRoll() + 1; i++) {
            ImageView dieView = allDiceViews.get(i);
            dieView.setVisibility(View.VISIBLE);
        }
    }

    private void hideAllDiceImageViews() {
        for (int i = 1; i < 8; i++) {
            ImageView dieView = allDiceViews.get(i);
            dieView.setVisibility(View.INVISIBLE);
            dieView.setBackgroundResource(0);
        }
    }

    private void changePlayerTurn() {
        currentPlayer *= -1;
    }

//    private void activateSelectedCardDialog() {
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        View view = getLayoutInflater().inflate(R.layout.activity_selected_card, null);
//
//        builder.setView(view);
//        AlertDialog dialog = builder.create();
//        dialog.show();
//    }

}