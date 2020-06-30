package nl.kaiherwijn.set.model;

public class Card {
    public enum Color {RED, GREEN, BLUE}
    public enum Fill {FULL, STRIPED, EMPTY}
    public enum Shape {SQUARE, OVAL, RHOMBUS}
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

    private Card() {}

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Fill getFill() {
        return fill;
    }

    public void setFill(Fill fill) {
        this.fill = fill;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

    public Number getNumber() {
        return number;
    }

    public void setNumber(Number number) {
        this.number = number;
    }

    public boolean equals(Card card) {
        return this.color == card.getColor() && this.fill == card.getFill() && this.shape == card.getShape() && this.number == card.getNumber();
    }
}
