package com.jastrzab;

import com.jastrzab.domain.ConsoleView;
import com.jastrzab.domain.HangmanGameService;
import com.jastrzab.domain.model.GameStatus;
import com.jastrzab.domain.model.Status;
import com.jastrzab.infrastructure.memory.InMemoryPhraseReposytory;

import java.io.IOException;
import java.util.Scanner;

public class App {
    final static Scanner scanner = new Scanner(System.in);
    static InMemoryPhraseReposytory inMemoryPhraseReposytory;
    private static HangmanGameService hangmanGameService;
    public static ConsoleView view = new ConsoleView();

    public static void main(String[] args) throws IOException {

        hangmanGameService = new HangmanGameService();
        inMemoryPhraseReposytory = new InMemoryPhraseReposytory();


        boolean appIsEnd = false;
        do {

            view.showStartMenu();;

            final int decision = Integer.parseInt(scanner.nextLine());
            switch (decision) {
                case 1: startGame();
                    break;
                case 2:
                    break;
                case 3: appIsEnd = true;
                    break;
                default: appIsEnd = false;
            }

        } while (!appIsEnd);

    }

    public static void startGame() throws IOException {

        String phrase = inMemoryPhraseReposytory.getPhrase();


        System.out.println("Enter your name: ");
        final String name = scanner.nextLine();
        view.waitForEnter("Press enter to start");

        final GameStatus gamesStatus = hangmanGameService.createGamesStatus(name, phrase);


        while (!gamesStatus.isFinished()) {

            int leftAttempts = (gamesStatus.getFiledMaxAttempts() - gamesStatus.getFailedAttempts());

            view.scrolScreen();
            System.out.println("Left "+leftAttempts+" attempts");
            //System.out.println("to delete Line  : "+ gamesStatus.getPhrase());
            System.out.println(view.renderPhrase(gamesStatus));
            System.out.println("Podaj koleja litere");
            final char letter = scanner.nextLine().charAt(0);
            hangmanGameService.processNextLetter(letter, gamesStatus);
        }

        System.out.println("\n\n\n\n\n");
        if (gamesStatus.getStatus() == Status.WIN){
            System.out.println("You win!");
        }else {
            System.out.println("You lose.");
        }
        System.out.println("Your total attempts: "+gamesStatus.getTotalAttempts());

        System.out.println("Press enter to continue");
        scanner.nextLine();
        System.out.println("\n\n\n\n\n");


    }
}
