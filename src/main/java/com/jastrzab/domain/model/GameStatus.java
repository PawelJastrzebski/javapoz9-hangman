package com.jastrzab.domain.model;

import lombok.Builder;

import java.util.HashSet;
import java.util.Set;

@Builder(toBuilder = true)
public class GameStatus {


    private int filedMaxAttempts;
    private String name;
    private String phrase;
    private Character[] phraseState;
    private Integer successAttempts;
    private Integer failedAttempts;
    private Set<Character> history;
    private Status status = Status.RUN;

    public GameStatus(String name, String phrase,int filedMaxAttempts) {
        this.name = name;
        this.phrase = phrase;
        this.filedMaxAttempts = filedMaxAttempts;
        this.phraseState = GameStatusHelper.preparePhraseState(phrase);
        this.successAttempts = 0;
        this.failedAttempts = 0;
        this.history = new HashSet<>();
    }

    public GameStatus(String name, String phrase){
        this(name,phrase,9);
    }

    private GameStatus(int filedMaxAttempts, String name, String phrase, Character[] phraseState, Integer successAttempts, Integer failedAttempts, Set<Character> history, Status status) {
        this.filedMaxAttempts = filedMaxAttempts;
        this.name = name;
        this.phrase = phrase;
        this.phraseState = phraseState;
        this.successAttempts = successAttempts;
        this.failedAttempts = failedAttempts;
        this.history = history;
        this.status = status;
    }

    public boolean isFinished(){

        if(this.failedAttempts>= this.filedMaxAttempts){
            return true;
        }
        for (Character character : this.getPhraseState()) {
            if(character == null){
                return false;
            }
        }
        return true;
    }
    public void incrementFailureCounter() {
        this.failedAttempts++;
    }
    public void incrementSuccessCounter() {
        this.successAttempts++;
    }


    public static class GameStatusHelper {
        public static Character[] preparePhraseState(String phrase){


            Character[] result = new Character[phrase.length()];
            final char[] chars = phrase.toCharArray();

            int index = 0;
            for (char aChar : chars) {
                if (Character.isLetter(aChar)){
                    result[index] = null;
                }else {
                    result[index] = aChar;
                }
                index++;
            }

            return result;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhrase() {
        return phrase;
    }

    public void setPhrase(String phrase) {
        this.phrase = phrase;
    }

    public Character[] getPhraseState() {
        return phraseState;
    }

    public void setPhraseState(Character[] phraseState) {
        this.phraseState = phraseState;
    }

    public Integer getSuccessAttempts() {
        return successAttempts;
    }

    public void setSuccessAttempts(Integer successAttempts) {
        this.successAttempts = successAttempts;
    }

    public Integer getFailedAttempts() {
        return failedAttempts;
    }

    public void setFailedAttempts(Integer failedAttempts) {
        this.failedAttempts = failedAttempts;
    }

    public Set<Character> getHistory() {
        return history;
    }

    public void setHistory(Set<Character> history) {
        this.history = history;
    }

    public int getFiledMaxAttempts() {
        return filedMaxAttempts;
    }

    public String getCurrentPhraseStatus(){
        final Character[] phraseState = GameStatusHelper.preparePhraseState(this.phrase);
        final int filedMaxAttempts = this.getFiledMaxAttempts();

        StringBuilder sb = new StringBuilder();
        for (Character aChar : phraseState) {
            if(aChar == null){
                sb.append("_");
            }else {
                sb.append(aChar);
            }
        }
        sb.append(" ("+(getFiledMaxAttempts() - getFailedAttempts())+")");
        return sb.toString();
    }

    public int getTotalAttempts(){
        return getSuccessAttempts()+getFailedAttempts();
    }

    public Status getStatus() {

        if(isFinished()){

            if(getFiledMaxAttempts() > getFailedAttempts()){
                return Status.WIN;
            }else{
                return Status.LOSE;
            }

        }else {
            return Status.RUN;
        }
    }
}
