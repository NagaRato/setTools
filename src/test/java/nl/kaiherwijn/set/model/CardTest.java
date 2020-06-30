package nl.kaiherwijn.set.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {
    private Card card1 = new Card(Card.Color.BLUE, Card.Fill.EMPTY, Card.Shape.SQUARE, Card.Number.TWO);
    private Card card01 = new Card(Card.Color.BLUE, Card.Fill.EMPTY, Card.Shape.SQUARE, Card.Number.TWO);

    private Card card02 = new Card(Card.Color.RED, Card.Fill.STRIPED, Card.Shape.OVAL, Card.Number.THREE);

    @Test
    void testEquals() {
        assertTrue(card1.equals(card01));
    }

    @Test
    void testNotEquals() {
        assertFalse(card02.equals(card01));
    }
}