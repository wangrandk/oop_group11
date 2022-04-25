package model.card;

import java.util.Comparator;

/**
 * Comparator for all the card classes. Compares the priority points of the cards.
 */

public class CardCompare implements Comparator<Card> {
    @Override
    public int compare(Card o1, Card o2) {
        return o2.getpoints() - o1.getpoints();
    }
}
