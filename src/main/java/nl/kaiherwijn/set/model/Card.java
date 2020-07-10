package nl.kaiherwijn.set.model;

import java.util.Arrays;
import java.util.List;

public class Card {

    public enum Color {RED, GREEN, BLUE}

    public enum Fill {FULL, STRIPED, EMPTY}

    public enum Shape {RECTANGLE, OVAL, RHOMBUS}

    public enum Number {ONE, TWO, THREE}

    private Color color;
    private Fill fill;
    private Shape shape;
    private Number number;

    public Card(Color color, Fill fill, Shape shape, Number number) {
        this.color = color;
        this.fill = fill;
        this.shape = shape;
        this.number = number;
    }

    private Card() {
    }

    public Color getColor() {
        return color;
    }

    public Fill getFill() {
        return fill;
    }

    public Shape getShape() {
        return shape;
    }

    public Number getNumber() {
        return number;
    }

    private void setColor(Color color) {
        this.color = color;
    }

    private void setFill(Fill fill) {
        this.fill = fill;
    }

    private void setShape(Shape shape) {
        this.shape = shape;
    }

    private void setNumber(Number number) {
        this.number = number;
    }

    public boolean equals(Card card) {

        return card != null && (this.color == card.getColor() && this.fill == card.getFill() && this.shape == card.getShape() && this.number == card.getNumber());
    }

    public static Card calculateComplementingCard(List<Card> cards) {
        Card complementingCard = new Card();
        if (cards.get(0).getColor() != cards.get(1).getColor()) {
            complementingCard.setColor(Arrays.stream(Color.values()).filter(color -> cards.get(0).getColor() != color && cards.get(1).getColor() != color).findFirst().get());
        } else {
            complementingCard.setColor(cards.get(0).getColor());
        }

        if (cards.get(0).getFill() != cards.get(1).getFill()) {
            complementingCard.setFill(Arrays.stream(Fill.values()).filter(fill -> cards.get(0).getFill() != fill && cards.get(1).getFill() != fill).findFirst().get());
        } else {
            complementingCard.setFill(cards.get(0).getFill());
        }

        if (cards.get(0).getShape() != cards.get(1).getShape()) {
            complementingCard.setShape(Arrays.stream(Shape.values()).filter(shape -> cards.get(0).getShape() != shape && cards.get(1).getShape() != shape).findFirst().get());
        } else {
            complementingCard.setShape(cards.get(0).getShape());
        }

        if (cards.get(0).getNumber() != cards.get(1).getNumber()) {
            complementingCard.setNumber(Arrays.stream(Number.values()).filter(number -> cards.get(0).getNumber() != number && cards.get(1).getNumber() != number).findFirst().get());
        } else {
            complementingCard.setNumber(cards.get(0).getNumber());
        }
        return complementingCard;
    }
}
