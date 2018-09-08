package com.jastrzab;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.*;

import static org.junit.Assert.*;

public class HangmanResultServiceTest {

    @Test
    public void getAllResult_should_work() {
        // given
        final RisultRepository mock = Mockito.mock(RisultRepository.class);
        final HangmanResultService hangmanResultService = new HangmanResultService(mock);

        final HashMap<String, List<String>> map = new HashMap<String, List<String>>() {{
            put("anna", Arrays.asList("1", "2"));
            put("Tom", Arrays.asList("1", "2"));
        }};

        new ArrayList<String>() {{
           add("Test");
        }};
        Mockito.when(mock.getResult()).thenReturn(map);
        //when

        final List<String> result = hangmanResultService.getResult();
        //then
        Assert.assertEquals( 2 , result.size());
    }
}