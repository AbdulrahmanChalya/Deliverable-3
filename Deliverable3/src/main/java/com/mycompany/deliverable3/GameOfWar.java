/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.deliverable3;

/**
 *
 * @author abdulrahman
 */
import java.util.Scanner;
import java.util.ArrayList;

public class GameOfWar {
    private final PlayerDeckOfCards player1;
    private final PlayerDeckOfCards player2;

    public GameOfWar() {
        ArrayList<Card> mainDeck = Card.generateDeck();

        player1 = new PlayerDeckOfCards();
        player2 = new PlayerDeckOfCards();

        while (!mainDeck.isEmpty()) {
            player1.addCard(mainDeck.remove(0));
            player2.addCard(mainDeck.remove(0));
        }
    }

    private void handleWar(PlayerDeckOfCards winner, PlayerDeckOfCards loser, Card card1, Card card2) {
        ArrayList<Card> warCards = new ArrayList<>();
        warCards.add(card1);
        warCards.add(card2);

        for (int i = 0; i < 3 && !winner.isEmpty() && !loser.isEmpty(); i++) {
            warCards.add(winner.draw());
            warCards.add(loser.draw());
        }

        if (winner.isEmpty() || loser.isEmpty()) {
            // One player ran out of cards, end the game
            return;
        }

        Card winnerCard = winner.draw();
        Card loserCard = loser.draw();
        System.out.println("PLAYER 1 DRAWS " + winnerCard + ", PLAYER 2 DRAWS " + loserCard);
        
        if (winnerCard.getValue() > loserCard.getValue()) {
            warCards.forEach(winner::addCard);
            winner.addCard(winnerCard);
            winner.addCard(loserCard);
            System.out.println("PLAYER 1 WINS THE WAR");
        } else if (winnerCard.getValue() < loserCard.getValue()) {
            warCards.forEach(loser::addCard);
            loser.addCard(loserCard);
            loser.addCard(winnerCard);
            System.out.println("PLAYER 2 WINS THE WAR");
        } else {
            // Another tie, continue the war
            handleWar(winner, loser, winnerCard, loserCard);
        }
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("PRESS ENTER TO BATTLE, PRESS “count” ENTER TO COUNT CARDS");
            String input = scanner.nextLine();

            if ("count".equalsIgnoreCase(input)) {
                System.out.println("PLAYER 1 HAS " + player1.size() + " CARDS");
                System.out.println("PLAYER 2 HAS " + player2.size() + " CARDS");
            } else {
                Card card1 = player1.draw();
                Card card2 = player2.draw();

                System.out.println("PLAYER 1 DRAWS " + card1 + ", PLAYER 2 DRAWS " + card2);

                if (card1.getValue() > card2.getValue()) {
                    System.out.println("PLAYER 1 WINS");
                    player1.addCard(card1);
                    player1.addCard(card2);
                } else if (card1.getValue() < card2.getValue()) {
                    System.out.println("PLAYER 2 WINS");
                    player2.addCard(card2);
                    player2.addCard(card1);
                } else {
                    System.out.println("AND WAR HAS STARTED");
                    handleWar(player1, player2, card1, card2);
                }

                if (player1.isEmpty()) {
                    System.out.println("PLAYER 2 HAS ALL 52 CARDS AND HAS WON THE GAME");
                    break;
                } else if (player2.isEmpty()) {
                    System.out.println("PLAYER 1 HAS ALL 52 CARDS AND HAS WON THE GAME");
                    break;
                }
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        GameOfWar game = new GameOfWar();
        game.play();
    }
}

