package com.jastrzab.domain;

import com.jastrzab.domain.model.GameStatus;

import java.io.IOException;

public class ConsoleView {

    public void showStartMenu(){

        System.out.println("1. Start");
        System.out.println("2. Wynik");
        System.out.println("3. Koniec");
    }

    public void scrolScreen(){
        System.out.println("\n\n\n\n\n\n");
    }
    public void waitForEnter(String mes){
        System.out.println(mes);
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String renderPhrase(GameStatus gameStatus){

        StringBuilder sb = new StringBuilder();

        for (Character aChar : gameStatus.getPhraseState()) {
            if(aChar == null){
                sb.append(" _ ");
            }else {
                sb.append(" "+aChar+" ");                }
        }
        sb.append("\n");
        return sb.toString();

    }
}
