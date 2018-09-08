package com.jastrzab.domain.model;

import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Arrays;
import com.jastrzab.domain.model.GameStatus.GameStatusHelper;

@RunWith(Enclosed.class)
public class GameStatusHelperTest {


    @Test
    public void ShouldReturnNullCharacterArray() {
        // given
        GameStatusHelper gameStatusHelper = new GameStatusHelper();
        String phraseInput = "Anna";
        String resultExpected = Arrays.toString(new Character[]{null, null, null, null});
        // then
        Character[] result = gameStatusHelper.preparePhraseState(phraseInput);
        final String formattedResult = Arrays.toString(result);
        //when
        Assert.assertEquals(resultExpected, formattedResult);
    }

    @Test
    public void ShouldReturnCharacterArrayWitchSpecialHarasser() {
        // given
        GameStatusHelper gameStatusHelper = new GameStatusHelper();
        String phraseInput = "Anna-Kot";
        String resultExpected = Arrays.toString(new Character[]{null, null, null, null, '-', null, null, null});
        // then
        Character[] result = gameStatusHelper.preparePhraseState(phraseInput);
        final String formattedResult = Arrays.toString(result);
        //when
        Assert.assertEquals(resultExpected, formattedResult);
    }
}