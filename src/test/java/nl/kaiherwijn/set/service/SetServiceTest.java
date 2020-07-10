package nl.kaiherwijn.set.service;

import nl.kaiherwijn.set.model.Card;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SetServiceTest {

    @Autowired
    private SetService setService = new SetService();

    @Test
    void isSetToFalseOfSingleCard() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.Color.BLUE, Card.Fill.EMPTY, Card.Shape.OVAL, Card.Number.ONE));

        assertFalse(SetService.isSet(cards));
    }

    @Test
    void isSetToFalseOfDuplicateCards() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.Color.BLUE, Card.Fill.EMPTY, Card.Shape.OVAL, Card.Number.ONE));
        cards.add(new Card(Card.Color.BLUE, Card.Fill.EMPTY, Card.Shape.OVAL, Card.Number.ONE));
        cards.add(new Card(Card.Color.RED, Card.Fill.EMPTY, Card.Shape.OVAL, Card.Number.ONE));

        assertFalse(SetService.isSet(cards));
    }

    @Test
    void isSetToTrueOfAlmostTheSameCards() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.Color.BLUE, Card.Fill.EMPTY, Card.Shape.OVAL, Card.Number.ONE));
        cards.add(new Card(Card.Color.RED, Card.Fill.EMPTY, Card.Shape.OVAL, Card.Number.ONE));
        cards.add(new Card(Card.Color.GREEN, Card.Fill.EMPTY, Card.Shape.OVAL, Card.Number.ONE));

        assertTrue(SetService.isSet(cards));
    }

    @Test
    void isSetToFalseOfAlmostCompletlyDifferentCards() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.Color.RED, Card.Fill.EMPTY, Card.Shape.RECTANGLE, Card.Number.TWO));
        cards.add(new Card(Card.Color.BLUE, Card.Fill.FULL, Card.Shape.OVAL, Card.Number.ONE));
        cards.add(new Card(Card.Color.GREEN, Card.Fill.STRIPED, Card.Shape.RHOMBUS, Card.Number.THREE));

        assertTrue(SetService.isSet(cards));
    }

    @Test
    void isSetToFalseOfFourCards() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.Color.RED, Card.Fill.EMPTY, Card.Shape.RECTANGLE, Card.Number.TWO));
        cards.add(new Card(Card.Color.BLUE, Card.Fill.FULL, Card.Shape.OVAL, Card.Number.ONE));
        cards.add(new Card(Card.Color.GREEN, Card.Fill.STRIPED, Card.Shape.RHOMBUS, Card.Number.THREE));
        cards.add(new Card(Card.Color.GREEN, Card.Fill.STRIPED, Card.Shape.RHOMBUS, Card.Number.ONE));

        assertFalse(SetService.isSet(cards));
    }
}