package nl.kaiherwijn.set.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {
    private Card card1 = new Card(Card.Color.BLUE, Card.Fill.EMPTY, Card.Shape.WAVE, Card.Number.TWO);
    private Card card01 = new Card(Card.Color.BLUE, Card.Fill.EMPTY, Card.Shape.WAVE, Card.Number.TWO);

    private Card card02 = new Card(Card.Color.RED, Card.Fill.STRIPED, Card.Shape.OVAL, Card.Number.THREE);
    private Card card03 = new Card(Card.Color.RED, Card.Fill.FULL, Card.Shape.OVAL, Card.Number.THREE);

    @Test
    void testEquals() {
        assertTrue(card1.equals(card01));
    }

    @Test
    void testNotEquals() {
        assertFalse(card02.equals(card03));
    }

    @Test
    void testComplementingCardOfAlmostTheSameCards() {
        Card complementingCard = Card.calculateComplementingCard(Arrays.asList(card02, card03));
        Card expectedCard = new Card(Card.Color.RED, Card.Fill.EMPTY, Card.Shape.OVAL, Card.Number.THREE);

        assertTrue(expectedCard.equals(complementingCard), "The method calculateComplementingCard(Card[]) does not return the comeplementing card for the set of two almost the same cards.");
    }

    @Test
    void testComplementingCardOfCompletelyDifferentCards() {
        Card complementingCard = Card.calculateComplementingCard(Arrays.asList(card01, card02));
        Card expectedCard = new Card(Card.Color.GREEN, Card.Fill.FULL, Card.Shape.RHOMBUS, Card.Number.ONE);

        assertTrue(expectedCard.equals(complementingCard), "The method calculateComplementingCard(Card[]) does not return the comeplementing card for the set of two completely different cards cards.");
    }
}