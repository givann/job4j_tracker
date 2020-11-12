package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public static void main(String[] args) {

        List<Card> listC = Stream.of(Suit.values())
                .flatMap(el -> Stream.of(Value.values()).map(value1 -> new Card(el, value1)))
                .collect(Collectors.toList());
    }
}
