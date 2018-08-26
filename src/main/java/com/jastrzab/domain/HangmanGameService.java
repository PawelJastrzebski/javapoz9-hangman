package com.jastrzab.domain;

import java.util.ArrayList;
import java.util.List;

public class HangmanGameService {

    public List<Integer> performCharacter(char c, String phrase){

        final ArrayList<Integer> result = new ArrayList<Integer>();
        final char[] charArray = phrase.toLowerCase().toCharArray();

        int index = 0;
        for (Character singleChar : charArray) {
            if(singleChar.equals(c)) {
                result.add(index);
            }
            index++;
        }

        return result;
    }
}
