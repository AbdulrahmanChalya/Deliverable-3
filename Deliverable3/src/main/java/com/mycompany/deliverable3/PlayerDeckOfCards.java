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
import java.util.Collections;

public class PlayerDeckOfCards {
    private ArrayList<Card> cards = new ArrayList<>();

    public void addCard(Card newCard) {
        cards.add(newCard);
    }

    public void removeCard(Card cardToRemove) {
        cards.remove(cardToRemove);
    }

    public Card getCard(int index) {
        return cards.get(index);
    }

    public Card draw() {
        if (isEmpty()) {
            return null;
        }
        return cards.remove(0);  // Remove and return the top card.
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public int size() {
        return cards.size();
    }
}

