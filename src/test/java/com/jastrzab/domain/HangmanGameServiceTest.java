package com.jastrzab.domain;

import com.jastrzab.domain.model.GameStatus;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class HangmanGameServiceTest {


    @Test
    public void ShouldReturnArrayWithAnyCheracterIndexes() {
        //Given
        HangmanGameService hangmanGameService = new HangmanGameService();
        //When
        List<Integer> result = hangmanGameService.performCharacter('a',"Anna");
        //Then
        Assert.assertEquals(2,result.size());
        Assert.assertEquals((Integer)0,result.get(0));
        Assert.assertEquals((Integer)3,result.get(1));
    }

    @Test
    public void ShouldReturnEmptyArrayWhenNotExistingCharInPhrase() {
        //Given
        HangmanGameService hangmanGameService = new HangmanGameService();
        //When
        List<Integer> result = hangmanGameService.performCharacter('c',"Anna");
        //Then
        Assert.assertEquals(0,result.size());
    }

    @Test
    public void ShouldReturnArrayWithAnyCheracterIndexesWhenPhraseContainsSpace() {
        //Given
        HangmanGameService hangmanGameService = new HangmanGameService();
        //When
        List<Integer> result = hangmanGameService.performCharacter('a',"ala ma kota");
        //Then
        Assert.assertEquals(4,result.size());
        Assert.assertEquals((Integer)0,result.get(0));
        Assert.assertEquals((Integer)2,result.get(1));
        Assert.assertEquals((Integer)5,result.get(2));
        Assert.assertEquals((Integer)10,result.get(3));
    }


    @Test
    public void processNextLetter_should_update_characterState_when_there_is_letter_in_phrase() {
        //Given
        HangmanGameService hangmanGameService = new HangmanGameService();
        Character aChar = 'a';
        GameStatus gameStatus = new GameStatus("testName","aaaa");
        //When
        hangmanGameService.processNextLetter(aChar, gameStatus);
        //Then
        Assert.assertEquals(gameStatus.getPhraseState()[0],(Character) 'a');
        Assert.assertEquals(gameStatus.getPhraseState()[3],(Character) 'a');

    }

    @Test
    public void processNextLetter_should_not_update_characterState_when_there_is_no_letter_in_phrase() {
        //Given
        HangmanGameService hangmanGameService = new HangmanGameService();
        Character aChar = 'a';
        GameStatus gameStatus = new GameStatus("testName","bbbb");
        //When
        hangmanGameService.processNextLetter(aChar, gameStatus);
        //Then
        Assert.assertEquals(gameStatus.getPhraseState()[0],(Character) null);
        Assert.assertEquals(gameStatus.getPhraseState()[3],(Character) null);

    }

    @Test
    public void processNextLetter_should_update_successAttempts_when_there_is_letter_in_phrase() {
        //Given
        HangmanGameService hangmanGameService = new HangmanGameService();
        Character aChar = 'a';
        GameStatus gameStatus = new GameStatus("testName","aaaa");
        //When
        hangmanGameService.processNextLetter(aChar, gameStatus);
        //Then
        Assert.assertEquals(gameStatus.getSuccessAttempts(),(Integer) 1);
    }

    @Test
    public void processNextLetter_should_update_failureAttempts_when_there_is_no_letter_in_phrase() {
        //Given
        HangmanGameService hangmanGameService = new HangmanGameService();
        Character aChar = 'a';
        GameStatus gameStatus = new GameStatus("testName","bbbb");
        //When
        hangmanGameService.processNextLetter(aChar, gameStatus);
        //Then
        Assert.assertEquals(gameStatus.getFailedAttempts(),(Integer) 1);
    }

    @Test
    public void processNextLetter_should_update_history_for_new_letter() {
        //Given
        HangmanGameService hangmanGameService = new HangmanGameService();
        Character aChar = 'a';
        GameStatus gameStatus = new GameStatus("testName","aaaa");
        //When
        hangmanGameService.processNextLetter(aChar, gameStatus);
        //Then
        Assert.assertTrue(gameStatus.getHistory().contains('a'));
    }

    @Test
    public void processNextLetter_should_not_update_history_for_existing_letter() {
        //Given
        HangmanGameService hangmanGameService = new HangmanGameService();
        Character aChar = 'a';
        GameStatus gameStatus = new GameStatus("testName","bbbb");
        //When
        hangmanGameService.processNextLetter(aChar, gameStatus);
        //Then
        Assert.assertTrue(gameStatus.getHistory().contains('a'));
    }
}
