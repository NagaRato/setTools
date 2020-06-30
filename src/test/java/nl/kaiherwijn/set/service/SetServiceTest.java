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
    void hasSetToOfSingleCard() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.Color.BLUE, Card.Fill.EMPTY, Card.Shape.OVAL, Card.Number.ONE));

        assertFalse(SetService.hasSet(cards));
    }

    @Test
    void hasSetOfDuplicateCards() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.Color.BLUE, Card.Fill.EMPTY, Card.Shape.OVAL, Card.Number.ONE));
        cards.add(new Card(Card.Color.BLUE, Card.Fill.EMPTY, Card.Shape.OVAL, Card.Number.ONE));
        cards.add(new Card(Card.Color.BLUE, Card.Fill.EMPTY, Card.Shape.OVAL, Card.Number.ONE));

        assertFalse(SetService.hasSet(cards));
    }

    @Test
    void hasSetToTrue() {
        List<Card> cards = new ArrayList<>();
        cards.add(new Card(Card.Color.BLUE, Card.Fill.EMPTY, Card.Shape.OVAL, Card.Number.ONE));
        cards.add(new Card(Card.Color.RED, Card.Fill.EMPTY, Card.Shape.OVAL, Card.Number.ONE));
        cards.add(new Card(Card.Color.GREEN, Card.Fill.EMPTY, Card.Shape.OVAL, Card.Number.ONE));

        assertTrue(SetService.hasSet(cards));
    }
}