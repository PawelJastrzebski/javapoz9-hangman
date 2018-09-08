package com.jastrzab.domain.model;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameStatusTest {


    @Test
    public void getCurrentPhraseStatusWithLeftAttempts_should_return_text_width_underscores_for_empty_phrase_state() {
        //given
        GameStatus gameStatus = new GameStatus("test","Ala ma kota",8);
        //then
        String state = gameStatus.getCurrentPhraseStatus();
        // when
        Assert.assertEquals("___ __ ____ (8)", state);
    }


    @Test
    public void isFinished_should_return_true_when_failureAttempts_equals_maxAttempts() {
        //given
        GameStatus gameStatus = new GameStatus("test","Ala ma kota",2);
        //then
        gameStatus.setFailedAttempts(2);

        // when
        Assert.assertTrue(gameStatus.isFinished());
    }

    @Test
    public void isFinished_should_return_false_when_maxAttempts_is_bigger_than_failureAttempts() {
        //given
        GameStatus gameStatus = new GameStatus("test","Ala ma kota",3);
        //then
        gameStatus.setFailedAttempts(2);

        // when
        Assert.assertFalse(gameStatus.isFinished());
    }

    @Test
    public void isFinished_should_return_true_when_all_letters_are_guessed() {
        //given
        char[] startPhrase = "Ala".toCharArray();
        Character[] finishedState = new Character[startPhrase.length];

        for (int i = 0; i < startPhrase.length ; i++) {
            finishedState[i] = startPhrase[i];
        }


        //then
        GameStatus gameStatus = new GameStatus("test","Ala",2)
                .toBuilder().phraseState(finishedState).build();

        // when
        Assert.assertTrue(gameStatus.isFinished());
    }
}