package com.jastrzab.domain;

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
}
