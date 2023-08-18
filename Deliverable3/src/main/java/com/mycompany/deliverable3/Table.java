/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.deliverable3;

/**
 *
 * @author abdulrahman
 */
import java.util.ArrayList;

public class Table {
    private ArrayList<Card> player1Hand = new ArrayList<>();
    private ArrayList<Card> player2Hand = new ArrayList<>();

    public void compareCards() {
        if (!player1Hand.isEmpty() && !player2Hand.isEmpty()) {
            Card player1Card = player1Hand.remove(0);
            Card player2Card = player2Hand.remove(0);

            System.out.println("PLAYER 1 DRAWS " + player1Card + ", PLAYER 2 DRAWS " + player2Card);

            if (player1Card.getValue() > player2Card.getValue()) {
                player1Hand.add(player1Card);
                player1Hand.add(player2Card);
                System.out.println("PLAYER 1 WINS");
            } else if (player1Card.getValue() < player2Card.getValue()) {
                player2Hand.add(player2Card);
                player2Hand.add(player1Card);
                System.out.println("PLAYER 2 WINS");
            } else {
                ArrayList<Card> warCards = new ArrayList<>();
                warCards.add(player1Card);
                warCards.add(player2Card);
                resolveWar(warCards);
            }
        }
    }

    private void resolveWar(ArrayList<Card> warCards) {
        if (player1Hand.size() < 2 || player2Hand.size() < 2) {
            System.out.println("Not enough cards for a war!");
            return;
        }

        System.out.println("WAR HAS STARTED");

        warCards.addAll(player1Hand.subList(0, 2));
        warCards.addAll(player2Hand.subList(0, 2));

        player1Hand.subList(0, 2).clear();
        player2Hand.subList(0, 2).clear();

        System.out.println("PLAYER 1 FLIPS " + player1Hand.get(0) + " AND DRAWS ONE CARD FACE DOWN");
        System.out.println("PLAYER 2 FLIPS " + player2Hand.get(0) + " AND DRAWS ONE CARD FACE DOWN");

        compareCards();
    }
}

