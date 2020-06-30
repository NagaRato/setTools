package nl.kaiherwijn.set.service;

import nl.kaiherwijn.set.model.Card;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SetService {
    public static Boolean hasSet(List<Card> cards) {
        if (cards.size() > 2) {
            return true;
        }
        else {
            return cards.size() == cards.stream().distinct().collect(Collectors.toCollection(ArrayList::new)).size();
        }

    }
}
