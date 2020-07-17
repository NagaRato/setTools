package nl.kaiherwijn.set.service;

import nl.kaiherwijn.set.model.Card;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SetService {
    public static Card calculateComplementingCard(List<Card> cards) {
        if (cards != null && cards.size()  == 2 && !cards.get(0).equals(cards.get(1))) {
            return Card.calculateComplementingCard(cards);
        }
        else {
            return null;
        }
    }

    public static boolean hasSet(List<Card> cards) {
        Optional<Card> foundCard = Optional.empty();
        if (containsDuplicates(cards)) {
            return false;
        }
        else {
            for (Card firstCard : cards) {
                for (Card secondCard : cards) {
                    if (!foundCard.isPresent()) {
                        foundCard = cards.stream().filter(c -> c.equals(calculateComplementingCard(Arrays.asList(firstCard, secondCard)))).findFirst();
                    }
                }
            }
        }
        return foundCard.isPresent();
    }

    public static boolean isSet(List<Card> cards) {
        if (cards.size() != 3 || containsDuplicates(cards)) {
            return false;
        }
        else if (isSetForColor(cards) && isSetForNumber(cards) && isSetForShape(cards) && isSetForFill(cards)) {
            return true;
        }
        else {
            return false;
        }
    }

    private static boolean isSetForColor(List<Card> cards) {
        return areAllDifferentColor(cards) || areAllSameColor(cards);
    }

    private static boolean areAllSameColor(List<Card> cards) {
        for (Card s : cards) {
            if(!s.getColor().equals(cards.get(0).getColor()))
                return  false;
        }
        return true;
    }

    private static boolean areAllDifferentColor(List<Card> list) {
        for (Card c : list) {
            if (list.stream().filter(i -> i.getColor() == c.getColor()).count() > 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSetForNumber(List<Card> cards) {
        return areAllDifferentNumber(cards) || areAllSameNumber(cards);
    }

    private static boolean areAllSameNumber(List<Card> cards) {
        for (Card s : cards) {
            if(!s.getNumber().equals(cards.get(0).getNumber()))
                return  false;
        }
        return true;
    }

    private static boolean areAllDifferentNumber(List<Card> list) {
        for (Card c : list) {
            if (list.stream().filter(i -> i.getNumber() == c.getNumber()).count() > 1) {
                return false;
            }
        }
        return true;
    }


    private static boolean isSetForFill(List<Card> cards) {
        return areAllDifferentFill(cards) || areAllSameFill(cards);
    }

    private static boolean areAllSameFill(List<Card> cards) {
        for (Card s : cards) {
            if(!s.getFill().equals(cards.get(0).getFill()))
                return  false;
        }
        return true;
    }

    private static boolean areAllDifferentFill(List<Card> list) {
        for (Card c : list) {
            if (list.stream().filter(i -> i.getFill() == c.getFill()).count() > 1) {
                return false;
            }
        }
        return true;
    }

    private static boolean isSetForShape(List<Card> cards) {
        return areAllDifferentShape(cards) || areAllSameShape(cards);
    }

    private static boolean areAllSameShape(List<Card> cards) {
        for (Card s : cards) {
            if(!s.getShape().equals(cards.get(0).getShape()))
                return  false;
        }
        return true;
    }

    private static boolean areAllDifferentShape(List<Card> list) {
        for (Card c : list) {
            if (list.stream().filter(i -> i.getShape() == c.getShape()).count() > 1) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean containsDuplicates(List<T> list){
        for (T t: list) {
            if (list.stream().filter(i -> i.equals(t)).count() > 1) {
                return true;
            }
        }
        return false;
    }
}
