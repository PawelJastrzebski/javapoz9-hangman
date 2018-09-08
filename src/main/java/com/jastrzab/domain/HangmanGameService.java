package com.jastrzab.domain;

import com.jastrzab.domain.model.GameStatus;

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

    public GameStatus createGamesStatus(String name , String phrase){
        return new GameStatus(name,phrase);
    }

    public void processNextLetter(char letter, GameStatus gamesStatus) {


        if( gamesStatus.getHistory().contains(letter)){
            gamesStatus.incrementFailureCounter();
        }else {

            final String phrase = gamesStatus.getPhrase();
            final List<Integer> letterIds = this.performCharacter(letter, phrase);
            letterIds.forEach((index)->{
                gamesStatus.getPhraseState()[index] = gamesStatus.getPhrase().charAt(index);
            });
            pronouncement(gamesStatus, (letterIds.size()>0));
            gamesStatus.getHistory().add(letter);
        }


    }

    private void pronouncement(GameStatus gamesStatus, boolean succes) {
        if(succes){
            gamesStatus.incrementSuccessCounter();;
        }else {
            gamesStatus.incrementFailureCounter();
        }
    }
}
